package cz.cvut.omo.sp.smart_home.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config
{
    private int floors;
    private int rooms;
    private int temperature;
    private JSONArray tracks;

    public Config(String block)
    {
        JSONParser parser = new JSONParser();
        try {
            JSONObject config = (JSONObject) parser.parse(new FileReader("src/main/java/cz/cvut/omo/sp/smart_home/config/house.json"));

            JSONObject selectedBlock = (JSONObject) config.get(block);
            switch (block) {
                case "temperature" -> temperature = ((Long) selectedBlock.get("temperature")).intValue();
                case "tracks" -> tracks = (JSONArray) selectedBlock.get("tracks");
                default -> {
                    floors = ((Long) selectedBlock.get("floors")).intValue();
                    rooms = ((Long) selectedBlock.get("rooms")).intValue();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public int getFloors()
    {
        return floors;
    }

    public int getRooms()
    {
        return rooms;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public List<String> getTracks()
    {
        return new ArrayList<>(tracks);
    }
}