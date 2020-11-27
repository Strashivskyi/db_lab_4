package ua.lviv.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "region")
@Entity
public class Region {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    private Set<City> cities;

    public Region(String name) {
        this.name = name;
    }
    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Region(int id, String name, Set<City> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }


    public Region() {

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

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
