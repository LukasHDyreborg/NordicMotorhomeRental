package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Economy extends Motorhome {
    private boolean fridge;
    private boolean toilet;
    private int gasBurners;
    private boolean awning;

    public Economy() {
    }

    public Economy(String licensePlate, String brand, String model, int pricePerDay, int seats, int beds,
                   String fuelType, int odometer, String registrationDate, String lengthAndHeight, String type,
                   boolean fridge, boolean toilet, int gasBurners, boolean awning) {
        super(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, odometer, registrationDate, lengthAndHeight, type);
        this.fridge = fridge;
        this.toilet = toilet;
        this.gasBurners = gasBurners;
        this.awning = awning;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isToilet() {
        return toilet;
    }

    public void setToilet(boolean toilet) {
        this.toilet = toilet;
    }

    public int getGasBurners() {
        return gasBurners;
    }

    public void setGasBurners(int gasBurners) {
        this.gasBurners = gasBurners;
    }

    public boolean isAwning() {
        return awning;
    }

    public void setAwning(boolean awning) {
        this.awning = awning;
    }
}
