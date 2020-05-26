package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {

    @Id
    private int id;
    private String name;
    private String initials;

    public Staff(){
    }

    public Staff(int id, String name, String initials){
        this.id = id;
        this.name = name;
        this.initials = initials;
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

}
