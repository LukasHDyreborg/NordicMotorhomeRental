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

    public Customer findCustomerById(int id){
        return customerRepository.findCustomerById(id);
    }

    public Customer addCustomer(Customer c){
        return customerRepository.addCustomer(c);
    }

    public Customer updateCustomer(Customer c){
        return customerRepository.updateCustomer(c);
    }

    public Customer deleteCustumer(int id){
        return customerRepository.deleteCustumer(id);
    }
}
