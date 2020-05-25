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
    private String zipCode;
    private String driverLicenseNumber;
    private String driverLicenseDate;

    public Customer() {
    }

    public Customer(int id, String name, int age, String cpr, String email, String phone, String address, String zipCode, String driverLicenseNumber, String driverLicenseDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpr = cpr;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverLicenseDate = driverLicenseDate;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseDate() {
        return driverLicenseDate;
    }

    public void setDriverLicenseDate(String driverLicenseDate) {
        this.driverLicenseDate = driverLicenseDate;
    }
}