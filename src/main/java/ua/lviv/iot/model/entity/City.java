package ua.lviv.iot.model.entity;

public class City {
    private int id;
    private int regionId;
    private String name;

    public City(int id, int regionId, String name) {
        this.id = id;
        this.regionId = regionId;
        this.name = name;
    }

    public City(int regionId, String name) {
        this.regionId = regionId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", name='" + name + '\'' +
                '}';
    }
}
