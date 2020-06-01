package com.example.demo;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import com.example.demo.Service.ContractService;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testAssignPrice(){
        Motorhome motorhome = new Motorhome("Nummerplade", "Brand", "Model", 500, 5, 6, "Benzin", "Automatisk", 10, "2020-02-02", "100x100", "Luksus",
        true, true, true);
        Contract c = new Contract(1000, "2020-05-20", "2020-05-21", 1, new Customer(), 1000, motorhome, motorhome.getLicensePlate(), 1200, 1, "James Raynor", new ArrayList<>(),
                "Vejen 13", 1, "Vejen 15", 1);
        c.getAccessoryList().add(new Accessory(1, "Bike", 12, 12, 50));
        c.getAccessoryList().add(new Accessory(2, "Helmet", 12, 12, 50));
        c.getAccessoryList().add(new Accessory(3, "Blanket", 12, 12, 50));

        contractRepository.assignPrice(c);
        assertEquals(801.4, c.getPrice());
    }
}