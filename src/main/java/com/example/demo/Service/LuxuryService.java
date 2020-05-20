package com.example.demo.Service;

import com.example.demo.Model.Luxury;
import com.example.demo.Repository.LuxuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuxuryService {
    @Autowired
    LuxuryRepository luxuryRepository;

    public List<Luxury> fetchAll() {
        return luxuryRepository.fetchAll();
    }

    public Luxury addLuxury(Luxury l) {
        return luxuryRepository.addLuxury(l);
    }

    public Luxury findLuxuryById(int id) {
        return luxuryRepository.findLuxuryById(id);
    }

    public Boolean deleteLuxury(int id) {
        return luxuryRepository.deleteLuxury(id);
    }

    public Luxury updateLuxury(Luxury l) {
        return luxuryRepository.updateLuxury(l);
    }
}
