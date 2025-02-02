import java.util.*;

class Room {
    private String roomNumber;
    private double area;
    private Building building;

    public Room(String roomNumber, double area, Building building) {
        this.roomNumber = roomNumber;
        this.area = area;
        this.building = building;
        building.addRoom(this);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getArea() {
        return area;
    }

    public Building getBuilding() {
        return building;
    }
}

class Building {
    private String streetName;
    private String houseNumber;
    private double monthlyPaymentPerSqM;
    private List<Room> rooms = new ArrayList<>();

    public Building(String streetName, String houseNumber, double monthlyPaymentPerSqM) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.monthlyPaymentPerSqM = monthlyPaymentPerSqM;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public double getTotalArea() {
        return rooms.stream().mapToDouble(Room::getArea).sum();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}

class City {
    private String name;
    private List<Building> buildings = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public Building findBuilding(String streetName, String houseNumber) {
        for (Building building : buildings) {
            if (building.getStreetName().equals(streetName) && building.getHouseNumber().equals(houseNumber)) {
                return building;
            }
        }
        return null;
    }
}

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
