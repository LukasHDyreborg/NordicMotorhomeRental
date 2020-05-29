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
    private int price;
    private String staff; //kan laves om til et objekt. fordelen ved en string er at vi kan slette medabejdere uden at det berører kontrakten (på den anden side: ændrer vi navn for medarbejder, så er det ikke ændret i kontrakten)
    @OneToMany
    private List<Accessory> accessoryList;
    // pick op
    private String pickUp;
    private double pickDistance;
   /* @OneToOne
    private Point pickUp;*/
    /* drop off
    @OneToOne
    private Point dropOff;*/
    private String dropOff;
    private double dropDistance;


    public Contract() {
    }

    /*public Contract(int id, String fromDate, String toDate,int numberOfDays, int customId, String carId, int maxKM, int price, Customer customer, Motorhome motorhome) {
        this.id = id;
        this.fromDate = LocalDate.parse(fromDate);
        this.toDate = LocalDate.parse(toDate);
        this.numberOfDays = numberOfDays;
        this.customId = customId;
        this.carId = carId;
        this.maxKM = maxKM;
        this.price = price;
        this.customer = customer;
        this.motorhome = motorhome;
    }*/

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

    public void setNumberOfDays(/*int numberOfDays*/) {
      //  this.numberOfDays = numberOfDays;
        Period period = Period.between(LocalDate.parse(fromDate), LocalDate.parse(toDate));
        this.numberOfDays = period.getDays();
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
