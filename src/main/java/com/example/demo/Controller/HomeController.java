package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public String customer(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        return "home/customer";
    }

    @GetMapping("/createCustomer")
    public String createCustomer(){
        return "home/createCustomer";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer c){
        boolean success = customerService.addCustomer(c);

        if(success){
            return "home/success";
        }else{
            return "home/failure";
        }
    }

    @GetMapping("/viewCustomer/{id}")
    public String viewCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "home/viewCustomer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id, Model model){
        boolean success = customerService.deleteCustumer(id);

        if(success){
            return "home/success";
        }
        else{
            return "home/failure";
        }
    }
}
