package com.example.demo.Service;

import com.example.demo.Model.Standard;
import com.example.demo.Repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardService {
    @Autowired
    StandardRepository standardRepository;

    public List<Standard> fetchAll() {
        return standardRepository.fetchAll();
    }

    public Standard addStandard(Standard s) {
        return standardRepository.addStandard(s);
    }

    public Standard findStandardById(int id) {
        return standardRepository.findStandardById(id);
    }

    public Boolean deleteStandard(int id) {
        return standardRepository.deleteStandard(id);
    }

    public Standard updateStandard(Standard s) {
        return standardRepository.updateStandard(s);
    }
}
