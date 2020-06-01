package com.example.demo;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import com.example.demo.Service.ContractService;
import com.example.demo.Service.CustomerService;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractTests {
    @Autowired
    ContractService contractService;
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    JdbcTemplate template;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MotorhomeRepository motorhomeRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    AccessoryRepository accessoryRepository;

    @Test
    @Order(1)
    public void testAssignPrice(){
        Motorhome motorhome = new Motorhome("Nummerplade", "Brand", "Model", 500, 5, 6, "Benzin", "Automatisk", 10, "2020-02-02", "100x100", "Luksus",
        true, true, true);
        Contract c = new Contract(1000, "2020-05-20", "2020-05-21", 1, new Customer(), 1000, motorhome, motorhome.getLicensePlate(), 1200, 1, "James Raynor", new ArrayList<>(),
                "Vejen 13", 1, "Vejen 15", 1);
        c.getAccessoryList().add(new Accessory(1, "Bike", 12, 12, 50));
        c.getAccessoryList().add(new Accessory(2, "Helmet", 12, 12, 50));
        c.getAccessoryList().add(new Accessory(3, "Blanket", 12, 12, 50));

        contractRepository.assignPrice(c);
        //Motorhome
        assertEquals(801.4, c.getPrice());
    }

   /* @Test
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
    }*/
}