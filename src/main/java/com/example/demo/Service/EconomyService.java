package com.example.demo.Service;

import com.example.demo.Model.Economy;
import com.example.demo.Repository.EconomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Lavet af LHD

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

    public Economy findById(String id) {
        return economyRepository.findById(id);
    }

    public Boolean delete(String id) {
        return economyRepository.delete(id);
    }

    public Economy update(Economy e, String licenseId) {
        return economyRepository.update(e, licenseId);
    }
}
