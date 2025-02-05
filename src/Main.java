import java.util.*;

public class Main {
    public static void main(String[] args) {
        City city = new City("Tufa");

        Building building1 = new Building("Main Street", "101", 15.0);
        Building building2 = new Building("Broadway", "202", 18.0);

        city.addBuilding(building1);
        city.addBuilding(building2);

        new Room("1A", 25.5, building1);
        new Room("1B", 30.0, building1);
        new Room("2A", 40.0, building2);

        System.out.println("Building information at " + building1.getStreetName() + " " + building1.getHouseNumber() + ":");
        System.out.println("Total area: " + building1.getTotalArea() + " sq.m");
        System.out.println("Rooms:");
        for (Room room : building1.getRooms()) {
            System.out.println("Room " + room.getRoomNumber() + " with area " + room.getArea() + " sq.m");
        }

        System.out.println("\nSearching for building at Main Street 101...");
        Building foundBuilding = city.findBuilding("Main Street", "101");
        if (foundBuilding != null) {
            System.out.println("Found building: " + foundBuilding.getStreetName() + " " + foundBuilding.getHouseNumber());
            System.out.println("Total area: " + foundBuilding.getTotalArea() + " sq.m");
            System.out.println("Rooms in this building:");
            for (Room room : foundBuilding.getRooms()) {
                System.out.println("Room " + room.getRoomNumber() + " with area " + room.getArea() + " sq.m");
            }
        } else {
            System.out.println("Building not found.");
        }
    }
}
