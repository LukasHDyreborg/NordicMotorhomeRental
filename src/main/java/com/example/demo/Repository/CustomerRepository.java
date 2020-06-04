package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
//Lavet af CBN & BAWG
@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll(){
        String sql = "SELECT * FROM customers ORDER BY id";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer findById(int id){
        String sql = "SELECT * FROM customers WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public boolean add(Customer c){
        /*try{*/
            String sql = "INSERT INTO customers() VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, c.getName(), c.getAge(), c.getEmail(), c.getCpr(), c.getPhone(), c.getAddress(), c.getZipCode(), c.getDriverLicenseNumber(), c.getDriverLicenseDate());
            return true;
        /*}catch(Exception e){
            return false;
        }*/
    }

    public Customer update(Customer c){
        String sql = "UPDATE customers SET `name` = ?, age = ?, email = ?, cpr = ?, phone = ?, address = ?, zipCode = ?, driverLicenseNumber = ?, driverLicenseDate = ? WHERE id = ?";
        template.update(sql, c.getName(), c.getAge(), c.getEmail(), c.getCpr(), c.getPhone(), c.getAddress(), c.getZipCode(), c.getDriverLicenseNumber(), c.getDriverLicenseDate(), c.getId());
        return null;
    }

    public Boolean delete(int id){
        try{
            String sql = "DELETE FROM customers WHERE id = ?";
            template.update(sql, id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
