package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    private int age;
    private String cpr;
    private String email;
    private String phone;
    private String address;
    private String zip_code;
    private String driver_license_number;
    private String driver_license_date;

    public Customer() {
    }

    public Customer(int id, String name, int age, String cpr, String email, String phone, String address, String zip_code, String driver_license_number, String driver_license_date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpr = cpr;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip_code = zip_code;
        this.driver_license_number = driver_license_number;
        this.driver_license_date = driver_license_date;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getDriver_license_number() {
        return driver_license_number;
    }

    public void setDriver_license_number(String driver_license_number) {
        this.driver_license_number = driver_license_number;
    }

    public String getDriver_license_date() {
        return driver_license_date;
    }

    public void setDriver_license_date(String driver_license_date) {
        this.driver_license_date = driver_license_date;
    }
}