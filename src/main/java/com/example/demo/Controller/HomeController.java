package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.*;
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
    @Autowired
    EconomyService economyService;
    @Autowired
    StandardService standardService;
    @Autowired
    LuxuryService luxuryService;
    @Autowired
    ContractService contractService;
    @Autowired
    MotorhomeService motorhomeService;


    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    //Customers
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
        boolean success = customerService.add(c);

        if(success){
            return "home/success";
        }else{
            return "home/failure";
        }
    }

    @GetMapping("/viewCustomer/{id}")
    public String viewCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "home/viewCustomer";
    }

    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "home/updateCustomer";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer c){
        customerService.update(c);
        return "redirect:/customer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        boolean success = customerService.delete(id);
        Luxury luxury = new Luxury();

        if(success){
            return "home/success";
        }
        else{
            return "home/failure";
        }
    }

    //Motorhomes
    @GetMapping("/motorhome")
    public String motorhome(Model model){
        List<Economy> economyList = economyService.fetchAll();
        List<Standard> standardList = standardService.fetchAll();
        List<Luxury> luxuryList = luxuryService.fetchAll();

        model.addAttribute("economies", economyList);
        model.addAttribute("standards", standardList);
        model.addAttribute("luxuries", luxuryList);
        return "home/motorhome";
    }

    @GetMapping("/createLuxury")
    public String createLuxury(){
        return "home/createLuxury";
    }

    @PostMapping("/createLuxury")
    public String createLuxury(@ModelAttribute Luxury luxury){
        luxuryService.add(luxury);
        return "redirect:/motorhome";
    }

    @GetMapping("/createStandard")
    public String createStandard(){
        return "home/createStandard";
    }

    @PostMapping("/createStandard")
    public String createLuxury(@ModelAttribute Standard standard){
        standardService.add(standard);
        return "redirect:/motorhome";
    }

    @GetMapping("/createEconomy")
    public String createEconomy(){
        return "home/createEconomy";
    }

    @PostMapping("/createEconomy")
    public String createEconomy(@ModelAttribute Economy economy){
        economyService.add(economy);
        return "redirect:/motorhome";
    }

    @GetMapping("/contract")
    public String contract(Model model){
        List<Contract> contractList = contractService.fetchAll();

        for(int i = 0; i < contractList.size(); i++){
            contractList.get(i).setCustomer(customerService.findById(contractList.get(i).getCustomId()));
        }

        for(int i = 0; i < contractList.size(); i++){
            contractList.get(i).setMotorhome(motorhomeService.findById(contractList.get(i).getCarId()));
        }
        model.addAttribute("contracts", contractList);

        return "home/contract";
    }
}
