package ua.lviv.iot.model.entity;

import javax.persistence.*;

@Table(name = "attraction")
@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "minimum_age")
    private int minimumAge;
    @ManyToOne
    @JoinColumn(name = "amusement_park_id", referencedColumnName = "id", nullable = false)
    private AmusementPark amusementPark;

    public Attraction(int id, String name, String description, int capacity, int minimumAge, AmusementPark amusementPark) {
        this.id = id;

    }

    public Attraction() {

    }

    public Attraction(String name, String description, Integer capacity, AmusementPark amusementPark, Integer minimumAge) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.minimumAge = minimumAge;
        this.amusementPark = amusementPark;
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

    public AmusementPark getAmusementPark() {
        return amusementPark;
    }

    public void setAmusementPark(AmusementPark amusementPark) {
        this.amusementPark = amusementPark;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", minimumAge=" + minimumAge +
                '}';
    }
}
