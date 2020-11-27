package ua.lviv.iot.model.entity;

import javax.persistence.*;

@Table(name = "ticket")
@Entity
public class Ticket {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "people_number")
    private int peopleNumber;
    @Column(name = "kids_number")
    private int kidsNumber;
    @Column(name = "price_in_USD")
    private int priceInUSD;
    @Column(name = "payment_time")
    private String paymentTime;
    @ManyToOne
    @JoinColumn(name = "amusement_park_id", referencedColumnName = "id", nullable = false)
    private AmusementPark amusementPark;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    public Ticket(int id, String arrivalTime, String departureTime, int peopleNumber, int kidsNumber, int priceInUSD, String paymentTime, AmusementPark amusementPark, Client client) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.peopleNumber = peopleNumber;
        this.kidsNumber = kidsNumber;
        this.priceInUSD = priceInUSD;
        this.paymentTime = paymentTime;
        this.amusementPark = amusementPark;
        this.client = client;
    }
    public Ticket(String arrivalTime, String departureTime, int peopleNumber, int kidsNumber, int priceInUSD, String paymentTime, AmusementPark amusementPark, Client client) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.peopleNumber = peopleNumber;
        this.kidsNumber = kidsNumber;
        this.priceInUSD = priceInUSD;
        this.paymentTime = paymentTime;
        this.amusementPark = amusementPark;
        this.client = client;
    }

    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public int getKidsNumber() {
        return kidsNumber;
    }

    public void setKidsNumber(int kidsNumber) {
        this.kidsNumber = kidsNumber;
    }

    public int getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(int priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public AmusementPark getAmusementPark() {
        return amusementPark;
    }

    public void setAmusementPark(AmusementPark amusementPark) {
        this.amusementPark = amusementPark;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", peopleNumber=" + peopleNumber +
                ", kidsNumber=" + kidsNumber +
                ", priceInUSD=" + priceInUSD +
                ", paymentTime='" + paymentTime + '\'' +
                ", amusementParkId=" + amusementPark.getId() +
                ", clientId=" + client.getId() +
                '}';
    }
}
