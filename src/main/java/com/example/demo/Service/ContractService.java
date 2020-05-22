package com.example.demo.Service;

import com.example.demo.Model.Contract;
import com.example.demo.Repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public Contract fetchAll() {
        return contractRepository.fetchAll();
    }

    public Contract add(Contract c) {
        return contractRepository.add(c);
    }

    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    public Boolean delete(int id) {
        return contractRepository.delete(id);
    }

    public Contract update(Contract c) {
        return contractRepository.update(c);
    }
}
