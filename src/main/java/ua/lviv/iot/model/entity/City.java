package ua.lviv.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "city")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    private Region region;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Set<AmusementPark> amusementParks;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Set<Client> clients;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public City(int id, String name, Region region, Set<AmusementPark> amusementParks, Set<Client> clients, Set<Employee> employees) {
        this.id = id;

        this.amusementParks = amusementParks;
        this.clients = clients;
        this.employees = employees;
    }

    public City() {

    }

    public City(String name, Region region) {
        this.name = name;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<AmusementPark> getAmusementParks() {
        return amusementParks;
    }

    public void setAmusementParks(Set<AmusementPark> amusementParks) {
        this.amusementParks = amusementParks;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", regionId=" + region.getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
