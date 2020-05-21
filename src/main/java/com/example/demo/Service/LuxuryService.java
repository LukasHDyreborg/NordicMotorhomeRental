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

    public Luxury add(Luxury l) {
        return luxuryRepository.add(l);
    }

    public Luxury findById(int id) {
        return luxuryRepository.findById(id);
    }

    public Boolean delete(int id) {
        return luxuryRepository.delete(id);
    }

    public Luxury update(Luxury l) {
        return luxuryRepository.update(l);
    }
}
