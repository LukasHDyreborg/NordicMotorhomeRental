package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Luxury extends Standard {
    private boolean tv;
    private boolean rearViewCamera;

    public Luxury() {
    }

    public Luxury(String licensePlate, String brand, String model, int pricePerDay, int seats, int beds,
                  String fuelType, String gear, int odometer, String registrationDate, String lengthAndHeight, String type,
                  boolean fridge, boolean toilet, boolean awning, boolean shower, boolean elStove, boolean tv, boolean rearViewCamera) {

        super(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate,
                lengthAndHeight, type, fridge, toilet, awning, shower, elStove);
        this.tv = tv;
        this.rearViewCamera = rearViewCamera;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isRearViewCamera() {
        return rearViewCamera;
    }

    public void setRearViewCamera(boolean rearViewCamera) {
        this.rearViewCamera = rearViewCamera;
    }
}
