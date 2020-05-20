package com.example.demo.Model;

import javax.persistence.Entity;

@Entity
public class Standard extends Motorhome{
    private boolean fridge;
    private boolean toilet;
    private boolean shower;
    private boolean elStove;
    private boolean awning;
    private boolean tv;
    private boolean rearViewCamera;

    public Standard() {
    }

    public Standard(String licensePlate, String brand, String model, int pricePerDay, int seats, int beds,
                    String fuelType, String gear, int odometer, String registrationDate, String lengthAndHeight,
                    String type, boolean fridge, boolean toilet, boolean shower, boolean elStove, boolean awning,
                    boolean tv, boolean rearViewCamera) {
        super(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, type);
        this.fridge = fridge;
        this.toilet = toilet;
        this.shower = shower;
        this.elStove = elStove;
        this.awning = awning;
        this.tv = tv;
        this.rearViewCamera = rearViewCamera;
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

    public boolean isAwning() {
        return awning;
    }

    public void setAwning(boolean awning) {
        this.awning = awning;
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
