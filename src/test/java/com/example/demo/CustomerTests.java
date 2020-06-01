package com.example.demo;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {
    @Autowired
    CustomerService customerService;
    @Autowired
    JdbcTemplate template;

    @Test
    public void testAdd(){
        Customer c = new Customer(1000, "Steve", 23, "12312312", "Steve@mail.com", "55883439", "Lygten 37", "4780",
                "1234567890", "2017-02-02");
        boolean success;
        try{
            String sql = "INSERT INTO customers() VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, c.getId(), c.getName(), c.getAge(), c.getEmail(), c.getCpr(), c.getPhone(), c.getAddress(), c.getZipCode(), c.getDriverLicenseNumber(), c.getDriverLicenseDate());
            success = true;
        }catch (Exception e){
            success = false;
        }
        assertTrue("It didnt add",success);
    }

    @Test
    public void testfind(){
        Customer customer = customerService.findById(1000);
        assertNotNull(customer);
        assertEquals("Steve", customer.getName());
    }

    @Test
    public void testUpdate(){
        testAdd();//it runs the delete test before this so we just add it again
        Customer c = customerService.findById(1000);
        c.setName("Stevie");
        c.setAddress("Lygten 10");
        customerService.update(c);

        Customer customer = customerService.findById(1000);
        assertEquals("Stevie", customer.getName());
        assertEquals("Lygten 10", customer.getAddress());
        customerService.delete(c.getId());
    }

    @Test
    public void testDelete(){
        Customer c = customerService.findById(1000);

        customerService.delete(c.getId());

        Customer customer = new Customer();
        try{
            customer = customerService.findById(1000); //if the customer still exists it will return it, if not = null
        }catch(EmptyResultDataAccessException e){
            customer = null;
        }
        assertNull(customer);
    }
}
