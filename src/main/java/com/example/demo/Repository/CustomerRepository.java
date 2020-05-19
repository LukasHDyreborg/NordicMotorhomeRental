package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll(){
        String sql = "SELECT * FROM customers ORDER BY id";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer findCustomerById(int id){
        String sql = "SELECT * FROM customers WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer c = template.queryForObject(sql, rowMapper, id);
        return c;
    }

    public boolean addCustomer(Customer c){
        try{
            String sql = "INSERT INTO customers() VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, c.getName(), c.getAge(), c.getCpr(), c.getEmail(), c.getPhone(), c.getAddress(), c.getZip_code(), c.getDriver_license_number(), c.getDriver_license_date());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Customer updateCustomer(Customer c){
        String sql = "UPDATE customers SET `name` = ?, age = ?, email = ?, cpr = ?, phone = ?, address = ?, zip_code = ?, driver_license_number = ?, driver_license_date = ? WHERE id = ?";
        template.update(sql, c.getName(), c.getAge(), c.getEmail(), c.getCpr(), c.getPhone(), c.getAddress(), c.getZip_code(), c.getDriver_license_number(), c.getDriver_license_date(), c.getId());
        return null;
    }

    public Boolean deleteCustumer(int id){
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
