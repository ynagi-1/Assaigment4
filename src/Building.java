import java.util.*;

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