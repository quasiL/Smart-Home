package cz.cvut.omo.sp.sh;

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
    private final JSONParser parser;
    private final String path;
    private int floors;
    private int rooms;
    private int temperature;
    private JSONArray tracks;

    public Config()
    {
        path = "config/house.json";
        parser = new JSONParser();
    }

    public int getFloors(String block)
    {
        try {
            JSONObject config = (JSONObject) parser.parse(new FileReader(path));
            JSONObject selectedBlock = (JSONObject) config.get(block);
            floors = ((Long) selectedBlock.get("floors")).intValue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return floors;
    }

    public int getRooms(String block)
    {
        try {
            JSONObject config = (JSONObject) parser.parse(new FileReader(path));
            JSONObject selectedBlock = (JSONObject) config.get(block);
            rooms = ((Long) selectedBlock.get("rooms")).intValue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public int getTemperature()
    {
        try {
            JSONObject config = (JSONObject) parser.parse(new FileReader(path));
            JSONObject selectedBlock = (JSONObject) config.get("temperature");
            temperature = ((Long) selectedBlock.get("temperature")).intValue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return temperature;
    }

    public List<String> getTracks()
    {
        try {
            JSONObject config = (JSONObject) parser.parse(new FileReader(path));
            JSONObject selectedBlock = (JSONObject) config.get("tracks");
            tracks = (JSONArray) selectedBlock.get("tracks");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tracks);
    }
}