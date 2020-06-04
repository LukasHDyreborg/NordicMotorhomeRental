package com.example.demo.Service;

import com.example.demo.Model.Standard;
import com.example.demo.Repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Lavet af LHD

@Service
public class StandardService {
    @Autowired
    StandardRepository standardRepository;

    public List<Standard> fetchAll() {
        return standardRepository.fetchAll();
    }

    public Standard add(Standard s) {
        return standardRepository.add(s);
    }

    public Standard findById(String id) {
        return standardRepository.findById(id);
    }

    public Boolean delete(String id) {
        return standardRepository.delete(id);
    }

    public Standard update(Standard s, String licenseId) {
        return standardRepository.update(s, licenseId);
    }
}
