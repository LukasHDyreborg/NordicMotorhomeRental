package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> fetchAll(){
        return customerRepository.fetchAll();
    }

    public Customer findById(int id){
        return customerRepository.findById(id);
    }

    public boolean add(Customer c){
        return customerRepository.add(c);
    }

    public Customer update(Customer c){
        return customerRepository.update(c);
    }

    public Boolean delete(int id){
        return customerRepository.delete(id);
    }
}
