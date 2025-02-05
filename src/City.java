import java.util.*;

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
