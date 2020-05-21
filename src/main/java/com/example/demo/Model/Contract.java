package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract {
    @Id
    private int id;
    private String fromDate;
    private String toDate;
    private int customerId;
    private String carId;
    private int maxKM;

    public Contract() {
    }

    public Contract(int id, String fromDate, String toDate, int customerId, String carId, int maxKM) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.customerId = customerId;
        this.carId = carId;
        this.maxKM = maxKM;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
}
