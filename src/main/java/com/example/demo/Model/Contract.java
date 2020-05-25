package com.example.demo.Model;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    private int id;
    private String fromDate;
    private String toDate;
    private int numberOfDays;
    @ManyToOne
    private Customer customer;
    private int customId;
    @ManyToOne
    private Motorhome motorhome;
    private String carId;
    private int maxKM;
    private int price;

    public Contract() {
    }

    public Contract(int id, String fromDate, String toDate,int numberOfDays, int customId, String carId, int maxKM, int price, Customer customer, Motorhome motorhome) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.numberOfDays = numberOfDays;
        this.customId = customId;
        this.carId = carId;
        this.maxKM = maxKM;
        this.price = price;
        this.customer = customer;
        this.motorhome = motorhome;
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

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customer_id) {
        this.customId = customer_id;
    }

    public Motorhome getMotorhome() {
        return motorhome;
    }

    public void setMotorhome(Motorhome motorhome) {
        this.motorhome = motorhome;
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
}
