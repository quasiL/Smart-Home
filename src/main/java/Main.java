import model.house.EmptyHouse;
import model.house.House;
import service.builder.Director;
import service.factory.EmptyHouseMaker;
import service.factory.HouseMaker;

public class Main
{
    public static void main(String[] args)
    {
        HouseMaker hm = new EmptyHouseMaker();
        House h = hm.createHouse();
        System.out.println(h.getRooms().get(1).getDevices().get(1).getName());
    }
}
