package com.example.demo.Service;

import com.example.demo.Model.Motorhome;
import com.example.demo.Repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Lavet af LHD

@Service
public class MotorhomeService {
    @Autowired
    MotorhomeRepository motorhomeRepository;

    public List<Motorhome> fetchAll() {
        return motorhomeRepository.fetchAll();
    }

    public Motorhome add(Motorhome m) {
        return motorhomeRepository.add(m);
    }

    public Motorhome findById(String id) {
        return motorhomeRepository.findById(id);
    }

    public Boolean delete(String id) {
        return motorhomeRepository.delete(id);
    }

    public Motorhome update(Motorhome m) {
        return motorhomeRepository.update(m);
    }
}