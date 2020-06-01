package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Standard extends Motorhome{
    private boolean shower;
    private boolean elStove;


    public Standard() {
    }

    public Standard(String licensePlate, String brand, String model, int pricePerDay, int seats, int beds,
                    String fuelType, String gear, int odometer, String registrationDate, String lengthAndHeight, String type,
                    boolean fridge, boolean toilet, boolean awning, boolean shower, boolean elStove) {
        super(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, type, fridge, toilet, awning);
        this.shower = shower;
        this.elStove = elStove;
    }

    public boolean isShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    public boolean isElStove() {
        return elStove;
    }

    public void setElStove(boolean elStove) {
        this.elStove = elStove;
    }
}
