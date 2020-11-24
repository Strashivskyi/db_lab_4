package ua.lviv.iot.model.entity;

public class AmusementPark {
    private int id;
    private int capacity;
    private String address;
    private String name;
    private int cityId;

    public AmusementPark(int id, int capacity, String address, String name, int cityId) {
        this.id = id;
        this.capacity = capacity;
        this.address = address;
        this.name = name;
        this.cityId = cityId;
    }

    public AmusementPark(int capacity, String address, String name, int cityId) {
        this.capacity = capacity;
        this.address = address;
        this.name = name;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "AmusementPark{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}

