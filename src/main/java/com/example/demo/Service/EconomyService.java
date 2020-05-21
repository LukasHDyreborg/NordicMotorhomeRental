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

    public Economy add(Economy e) {
        return economyRepository.add(e);
    }

    public Economy findById(int id) {
        return economyRepository.findById(id);
    }

    public Boolean delete(int id) {
        return economyRepository.delete(id);
    }

    public Economy update(Economy e) {
        return economyRepository.update(e);
    }
}
