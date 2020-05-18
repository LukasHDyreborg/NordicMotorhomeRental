package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Motorhome {
    @Id
    private String licensePlate;
    private String Brand;
    private String Model;
    private double pricePerDay;
    private int seats;
    private int beds;
    private String fuelType;
    private int odometer;
    private String registrationDate;
}