package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contract {
    @Id
    private int id;
    private String fromDate;
    private String toDate;
    private int customerId;
    private String carId;
    private int maxKM;
    private int price;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Motorhome motohome;

    public Contract() {
    }

    public Contract(int id, String fromDate, String toDate, int customerId, String carId, int maxKM, int price, Customer customer, Motorhome motorhome) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.customerId = customerId;
        this.carId = carId;
        this.maxKM = maxKM;
        this.price = price;
        this.customer = customer;
        this.motohome = motorhome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getMaxKM() {
        return maxKM;
    }

    public void setMaxKM(int maxKM) {
        this.maxKM = maxKM;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Motorhome getMotohome() {
        return motohome;
    }

    public void setMotohome(Motorhome motohome) {
        this.motohome = motohome;
    }
}
