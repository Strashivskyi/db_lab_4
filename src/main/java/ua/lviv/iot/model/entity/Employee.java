package ua.lviv.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "gender")
    private String gender;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;
    @ManyToOne
    @JoinColumn(name = "amusement_park_id", referencedColumnName = "id", nullable = false)
    private AmusementPark amusementPark;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;

    public Employee(int id, String phoneNumber, String email, String birthday, String gender, String firstName, String lastName, Position position, AmusementPark amusementPark, City city) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.amusementPark = amusementPark;
        this.city = city;
    }

    public Employee() {

    }

    public Employee(String phoneNumber, String email, String birthday, String gender, Position position, String firstName, String lastName, City city, AmusementPark amusementPark) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.amusementPark = amusementPark;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public AmusementPark getAmusementPark() {
        return amusementPark;
    }

    public void setAmusementPark(AmusementPark amusementPark) {
        this.amusementPark = amusementPark;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", positionId=" + position.getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cityId=" + city.getId() +
                ", amusementParkId=" + amusementPark.getId() +
                '}';
    }
}