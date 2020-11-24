package ua.lviv.iot.model.entity;

public class Attraction {
    private int id;
    private String name;
    private String description;
    private int capacity;
    private int amusementParkId;
    private int minimumAge;

    public Attraction(int id, String name, String description, int capacity, int amusementParkId, int minimumAge) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.amusementParkId = amusementParkId;
        this.minimumAge = minimumAge;
    }

    public Attraction(String name, String description, int capacity, int amusementParkId, int minimumAge) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.amusementParkId = amusementParkId;
        this.minimumAge = minimumAge;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getAmusementParkId() {
        return amusementParkId;
    }

    public void setAmusementParkId(int amusementParkId) {
        this.amusementParkId = amusementParkId;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", amusementParkId=" + amusementParkId +
                ", minimumAge=" + minimumAge +
                '}';
    }
}
