package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Motorhome {
    @Id
    private String licensePlate;
    private String brand;
    private String model;
    private int pricePerDay;
    private int seats;
    private int beds;
    private String fuelType;
    private int odometer;
    private String registrationDate;
    private String lengthAndHeight;
    private String type;

    public Motorhome() {
    }

    public Motorhome(String licensePlate, String brand, String model, int pricePerDay, int seats, int beds,
                     String fuelType, int odometer, String registrationDate, String lengthAndHeight, String type) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.seats = seats;
        this.beds = beds;
        this.fuelType = fuelType;
        this.odometer = odometer;
        this.registrationDate = registrationDate;
        this.lengthAndHeight = lengthAndHeight;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        model = model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLengthAndHeight() {
        return lengthAndHeight;
    }

    public void setLengthAndHeight(String lengthAndHeight) {
        lengthAndHeight = lengthAndHeight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}