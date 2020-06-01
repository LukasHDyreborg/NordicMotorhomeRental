package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Economy extends Motorhome {
    private int gasBurners;

    public Economy() {
    }

    public Economy(String licensePlate, String brand, String model, int pricePerDay, int seats, int beds,
                   String fuelType, String gear, int odometer, String registrationDate, String lengthAndHeight, String type,
                   boolean fridge, boolean toilet, boolean awning, int gasBurners) {
        super(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, type, fridge, toilet, awning);
        this.gasBurners = gasBurners;
    }

    public int getGasBurners() {
        return gasBurners;
    }

    public void setGasBurners(int gasBurners) {
        this.gasBurners = gasBurners;
    }
}
