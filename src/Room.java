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