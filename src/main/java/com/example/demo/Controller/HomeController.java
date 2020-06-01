package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    SeasonService seasonService;
    @Autowired
    AccessoryService accessoryService;
    @Autowired
    StaffService staffService;


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

    @GetMapping("/viewMotorhome/{id}")
    public String viewMotorhome(@PathVariable("id") String id, Model model){
        Motorhome motorhome = motorhomeService.findById(id);
        model.addAttribute(motorhome);

        if(motorhome.getType().equals("Luksus")){
            model.addAttribute(luxuryService.findById(id));
        }else if(motorhome.getType().equals("Standard")){
            model.addAttribute(standardService.findById(id));
        }else{
            model.addAttribute(economyService.findById(id));
        }
        return "home/viewMotorhome";
    }
    @GetMapping("/deleteMotorhome/{id}")
    public String deleteMotorhome(@PathVariable("id") String id) {
        boolean success = motorhomeService.delete(id);

        if(success){
            return "home/success";
        } else{
            return "home/failure";
        }
    }

    @GetMapping("/updateEconomy/{id}")
    public String updateEconomy(@PathVariable("id") String id, Model model){
        model.addAttribute("economy", economyService.findById(id));
        return "home/updateEconomy";
    }
    @PostMapping("/updateEconomy")
    public String updateEconomy(@ModelAttribute Economy e, @RequestParam("licenseId") String licensePlate){
        economyService.update(e, licensePlate);
        return "redirect:/motorhome";
    }
    @GetMapping("/updateStandard/{id}")
    public String updateStandard(@PathVariable("id") String id, Model model){
        model.addAttribute("standard", standardService.findById(id));
        return "home/updateStandard";
    }
    @PostMapping("/updateStandard")
    public String updateLuxury(@ModelAttribute Standard s, @RequestParam("licenseId") String licensePlate){
        standardService.update(s, licensePlate);
        return "redirect:/motorhome";
    }
    @GetMapping("/updateLuxury/{id}")
    public String updateLuxury(@PathVariable("id") String id, Model model){
        model.addAttribute("luxury", luxuryService.findById(id));
        return "home/updateLuxury";
    }
    @PostMapping("/updateLuxury")
    public String updateLuxury(@ModelAttribute Luxury l, @RequestParam("licenseId") String licensePlate){
        luxuryService.update(l, licensePlate);
        return "redirect:/motorhome";
    }


    //Contracts
    @GetMapping("/contract")
    public String contract(Model model){
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts", contractList);

        return "home/contract";
    }

    @GetMapping("/endContract/{id}")
    public String endContract(@PathVariable("id") int id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        model.addAttribute("staffs", staffService.fetchAll());
        return "home/endContract";
    }

    @PostMapping("/endContract")
    public String endContract(@RequestParam("contractId") int id,
                              @RequestParam(value="halfFull", required=false) boolean halfFull,
                              @RequestParam("odometer") int odometer,
                              @RequestParam("staff") String staff, Model model) {
        Contract c = contractService.findById(id);
        c.setStaff(staff);
        int price = contractService.endContract(c, odometer, halfFull);

        model.addAttribute("contract", c);//we use the contract for an if statement
        model.addAttribute("price", price); //the amount the customer gets og pays
        model.addAttribute("halfFull", halfFull);
        model.addAttribute("odometer", odometer);

        return "home/contractPay";
    }

    @GetMapping("/contractArchive")
    public String contractArchive(Model model){
        List<Contract> contractList = contractService.fetchAllArchive();
        model.addAttribute("contracts", contractList);

        return "home/contractArchive";
    }

    @GetMapping("/viewContractArchived/{id}")
    public String viewContractArchived(@PathVariable("id") int id, Model model) {
        Contract contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "home/viewContractArchived";
    }

    @GetMapping("/createContract")
    public String createContract(Model model) {
        List<Customer> customerList = customerService.fetchAll();
        List<Economy> economyList = economyService.fetchAll();
        List<Standard> standardList = standardService.fetchAll();
        List<Luxury> luxuryList = luxuryService.fetchAll();
        List<Staff> staffList = staffService.fetchAll();
        List<Accessory> accessoryList = accessoryService.fetchAllAvailable();

        model.addAttribute("customers", customerList);
        model.addAttribute("economies", economyList);
        model.addAttribute("standards", standardList);
        model.addAttribute("luxuries", luxuryList);
        model.addAttribute("staffs", staffList);
        model.addAttribute("accessories", accessoryList);
        return "home/createContract";
    }

    @PostMapping("/createContract")
    public String createContract(@ModelAttribute Contract contract, @RequestParam(value="accessory", required=false) int[] accessory){
        if(accessory==null){
            accessory = new int[]{}; // initialize an empty array if there isnt an accessory chosen
        }
        contractService.add(contract, accessory);
        return "redirect:/contract";
    }

    @GetMapping("/viewContract/{id}")
    public String viewContract(@PathVariable("id") int id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "home/viewContract";
    }

    @GetMapping("/deleteContract/{id}")
    public String deleteContract(@PathVariable("id") int id) {
        boolean success = contractService.delete(id);

        if(success){
            return "home/success";
        }
        else{
            return "home/failure";
        }
    }

    @GetMapping("/updateContract/{id}")
    public String updateContract(@PathVariable("id") int id, Model model) {
        List<Customer> customerList = customerService.fetchAll();
        List<Economy> economyList = economyService.fetchAll();
        List<Standard> standardList = standardService.fetchAll();
        List<Luxury> luxuryList = luxuryService.fetchAll();
        List<Staff> staffList = staffService.fetchAll();
        List<Accessory> accessoryList = accessoryService.fetchAllAvailable(); // what if the contract we edit has the last of an item( availability = 0), then it won't be showed as an option (and will then be removed when you press update)
        Contract contract = contractService.findById(id);

        List<Integer> contractAccessories = new ArrayList<>(); //used to compare if accessory is in contract (hvis listen indeholder accessory.id)
        for(int i = 0; i < contract.getAccessoryList().size(); i++){
            contractAccessories.add(contract.getAccessoryList().get(i).getId()); //adds ids from contract to list
        }

        model.addAttribute("contract", contract);
        model.addAttribute("customers", customerList);
        model.addAttribute("economies", economyList);
        model.addAttribute("standards", standardList);
        model.addAttribute("luxuries", luxuryList);
        model.addAttribute("staffs", staffList);
        model.addAttribute("accessories", accessoryList);
        model.addAttribute("contractAccessories", contractAccessories);
        return "home/updateContract";
    }

    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract c, @RequestParam(value="accessory", required=false) int[] accessory,
                                 @RequestParam(value="newPrice", required=false) boolean newPrice) {
        if(accessory==null){
            accessory = new int[]{}; // initialize an empty array if there isnt an accessory chosen
        }
        contractService.update(c, accessory, newPrice);
        return "redirect:/contract";
    }

    //season
    @GetMapping("/season")
    public String season(Model model){
        List<Season> seasonList = seasonService.fetchAll();
        model.addAttribute("seasons", seasonList);
        return "home/season";
    }

    @GetMapping("/createSeason")
    public String createSeason() {
        return "home/createSeason";
    }

    @PostMapping("/createSeason")
    public String createSeason(@ModelAttribute Season s){
        boolean success = seasonService.add(s);

        if(success){
            return "home/success";
        }else{
            return "home/failure";
        }
    }

    @GetMapping("/viewSeason/{id}")
    public String viewSeason(@PathVariable("id") int id, Model model){
        model.addAttribute("season", seasonService.findById(id));
        return "home/viewSeason";
    }

    @GetMapping("/updateSeason/{id}")
    public String updateSeason(@PathVariable("id") int id, Model model){
        model.addAttribute("season", seasonService.findById(id));
        return "home/updateSeason";
    }
    @PostMapping("/updateSeason")
    public String updateSeason(@ModelAttribute Season c){
        seasonService.update(c);
        return "redirect:/season";
    }

    @GetMapping("/deleteSeason/{id}")
    public String deleteSeason(@PathVariable("id") int id){
        boolean success = seasonService.delete(id);

        if(success){
            return "home/success";
        }
        else{
            return "home/failure";
        }
    }
    //accessory
    @GetMapping("/accessory")
    public String accessory(Model model){
        List<Accessory> accessoryList = accessoryService.fetchAll();
        model.addAttribute("accessories",accessoryList);
        return "home/accessory";
    }

    @GetMapping("/createAccessory")
    public String createAccessory() {
        return "home/createAccessory";
    }

    @PostMapping("/createAccessory")
    public String createAccessory(@ModelAttribute Accessory a){
        boolean success = accessoryService.add(a);

        if(success){
            return "home/success";
        }else{
            return "home/failure";
        }
    }

    @GetMapping("/viewAccessory/{id}")
    public String viewAccessory(@PathVariable("id") int id, Model model){
        model.addAttribute("accessory", accessoryService.findById(id));
        return "home/viewAccessory";
    }

    @GetMapping("/updateAccessory/{id}")
    public String updateAccessory(@PathVariable("id") int id, Model model){
        model.addAttribute("accessory", accessoryService.findById(id));
        return "home/updateAccessory";
    }
    @PostMapping("/updateAccessory")
    public String updateAccessory(@ModelAttribute Accessory a){
        accessoryService.update(a);
        return "redirect:/accessory";
    }

    @GetMapping("/deleteAccessory/{id}")
    public String deleteAccessory(@PathVariable("id") int id){
        boolean success = accessoryService.delete(id);
        if(success){
            return "home/success";
        }
        else{
            return "home/failure";
        }
    }

    //staff
    @GetMapping("/staff")
    public String staff(Model model){
        List<Staff> staffList = staffService.fetchAll();
        model.addAttribute("staffs", staffList);
        return "home/staff";
    }

    @GetMapping("/createStaff")
    public String createStaff() {
        return "home/createStaff";
    }

    @PostMapping("/createStaff")
    public String createStaff(@ModelAttribute Staff s){
        boolean success = staffService.add(s);

        if(success){
            return "home/success";
        }else{
            return "home/failure";
        }
    }

    @GetMapping("/viewStaff/{id}")
    public String viewStaff(@PathVariable("id") int id, Model model){
        model.addAttribute("staff", staffService.findById(id));
        return "home/viewStaff";
    }

    @GetMapping("/updateStaff/{id}")
    public String updateStaff(@PathVariable("id") int id, Model model){
        model.addAttribute("staff", staffService.findById(id));
        return "home/updateStaff";
    }
    @PostMapping("/updateStaff")
    public String updateStaff(@ModelAttribute Staff s){
        staffService.update(s);
        return "redirect:/staff";
    }

    @GetMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable("id") int id){
        boolean success = staffService.delete(id);

        if(success){
            return "home/success";
        }
        else{
            return "home/failure";
        }
    }
}
