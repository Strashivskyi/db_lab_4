package ua.lviv.iot.model.entity;

public class Ticket {
    private int id;
    private String arrivalTime;
    private String departureTime;
    private int peopleNumber;
    private int kidsNumber;
    private int priceInUSD;
    private int clientId;
    private int amusementParkId;
    private String paymentTime;

    public Ticket(int id, String arrivalTime, String departureTime, int peopleNumber, int kidsNumber, int priceInUSD, int clientId, int amusementParkId, String paymentTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.peopleNumber = peopleNumber;
        this.kidsNumber = kidsNumber;
        this.priceInUSD = priceInUSD;
        this.clientId = clientId;
        this.amusementParkId = amusementParkId;
        this.paymentTime = paymentTime;
    }

    public Ticket(String arrivalTime, String departureTime, int peopleNumber, int kidsNumber, int priceInUSD, int clientId, int amusementParkId, String paymentTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.peopleNumber = peopleNumber;
        this.kidsNumber = kidsNumber;
        this.priceInUSD = priceInUSD;
        this.clientId = clientId;
        this.amusementParkId = amusementParkId;
        this.paymentTime = paymentTime;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAmusementParkId() {
        return amusementParkId;
    }

    public void setAmusementParkId(int amusementParkId) {
        this.amusementParkId = amusementParkId;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
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
                ", clientId=" + clientId +
                ", amusementParkId=" + amusementParkId +
                ", paymentTime='" + paymentTime + '\'' +
                '}';
    }
}
