package com.example.demo.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Contract {
    @Id
    private int id;
    private String fromDate;
    private String toDate;
    private int numberOfDays; // kan udregnes fra ovenstående to fields
    @ManyToOne
    private Customer customer;
    private int customId; //kommer til at være i customer alligvel
    @ManyToOne
    private Motorhome motorhome;
    private String carId;  //kommer til at være i motorhome
    private int maxKM;
    private double price; // i euro
    private String staff;
    @OneToMany
    private List<Accessory> accessoryList;
    private String pickUp;
    private double pickDistance;
    private String dropOff;
    private double dropDistance;


    public Contract() {
    }

    public Contract(int id, String fromDate, String toDate, int numberOfDays, Customer customer, int customId,
                    Motorhome motorhome, String carId, int maxKM, int price, String staff, List<Accessory> accessoryList,
                    String pickUp, double pickDistance, String dropOff, double dropDistance){
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.numberOfDays = numberOfDays;
        this.customer = customer;
        this.customId = customId;
        this.motorhome = motorhome;
        this.carId = carId;
        this.maxKM = maxKM;
        this.price = price;
        this.staff = staff;
        this.accessoryList = accessoryList;
        this.pickUp = pickUp;
        this.pickDistance = pickDistance;
        this.dropOff = dropOff;
        this.dropDistance = dropDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDate() {
        return String.valueOf(fromDate); // returns the localdate as a string for our browser (since browsers apparently dont like date objects- BG
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return String.valueOf(toDate);
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setDays() {
        Period period = Period.between(LocalDate.parse(fromDate), LocalDate.parse(toDate));
        this.numberOfDays = period.getDays();
    }

    public void setNumberOfDays(int days) {
        this.numberOfDays = days;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.round(price*100);
        this.price /= 100;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public List<Accessory> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(List<Accessory> accessoryList) {
        this.accessoryList = accessoryList;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public double getPickDistance() {
        return pickDistance;
    }

    public void setPickDistance(double pickDistance) {
        this.pickDistance = pickDistance;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public double getDropDistance() {
        return dropDistance;
    }

    public void setDropDistance(double dropDistance) {
        this.dropDistance = dropDistance;
    }

}
