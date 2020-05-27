package com.example.demo.Service;

import com.example.demo.Model.Contract;
import com.example.demo.Repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public List<Contract> fetchAll() {
        return contractRepository.fetchAll();
    }

    public Contract add(Contract c, int[] accessory) {
        return contractRepository.add(c, accessory);
    }

    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    public Boolean delete(int id) {
        return contractRepository.delete(id);
    }

    public Contract update(Contract c, int[] accessories) {
        return contractRepository.update(c, accessories);
    }
}
