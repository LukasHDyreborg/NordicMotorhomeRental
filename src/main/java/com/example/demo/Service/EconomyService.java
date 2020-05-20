package com.example.demo.Service;

import com.example.demo.Model.Economy;
import com.example.demo.Repository.EconomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomyService {
    @Autowired
    EconomyRepository economyRepository;

    public List<Economy> fetchAll() {
        return economyRepository.fetchAll();
    }

    public Economy addEconomy(Economy e) {
        return economyRepository.addEconomy(e);
    }

    public Economy findEconomyById(int id) {
        return economyRepository.findEconomyById(id);
    }

    public Boolean deleteEconomy(int id) {
        return economyRepository.deleteEconomy(id);
    }

    public Economy updateEconomy(Economy e) {
        return economyRepository.updateEconomy(e);
    }
}
