package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accessory {
    @Id
    private int id;
    private String name;
    private int amountAvailable;
    private int amountTotal;
    private int price;

    public Accessory(){
    }

    public Accessory(int id, String name, int amountAvailable, int amountTotal, int price){
        this.id = id;
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountTotal = amountTotal;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public int getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(int amountTotal) {
        this.amountTotal = amountTotal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}