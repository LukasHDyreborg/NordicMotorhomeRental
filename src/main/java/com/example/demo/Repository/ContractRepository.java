package com.example.demo.Repository;

import com.example.demo.Model.Accessory;
import com.example.demo.Model.Contract;
import com.example.demo.Model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractRepository {
    @Autowired
    JdbcTemplate template;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MotorhomeRepository motorhomeRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    AccessoryRepository accessoryRepository;

    public List<Contract> fetchAll() {
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price, staff FROM contracts c JOIN customers cust ON c.customId = cust.id JOIN motorhomes m ON c.carId = m.licensePlate ORDER BY c.id";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        List<Contract> contractList = template.query(sql, rowMapper);
        //assigns accessories to contract
        for(int i = 0; i <contractList.size(); i++){
            Contract contract = contractList.get(i);
            contract.setAccessoryList(assignContractAccessories(contract));
        }
        //assigns customer and vehicle to contract
        for(int i = 0; i < contractList.size(); i++){
            assignContract(contractList.get(i));
        }
        return contractList;
    }

    public Contract add(Contract c, int[] accessory) {
        /*try{*/
            c.setId(IdRetriever.retrieveID("id", "contracts"));

            c.setAccessoryList(new ArrayList<>());//assigns it an arraylist since it will be null by default

            //adds accessories from list
            for(int i = 0; i < accessory.length; i++){
                c.getAccessoryList().add(accessoryRepository.findById(accessory[i]));
            }

            //sets number of days because it wont do itself for some reason ( ._.)
            Period period = Period.between(LocalDate.parse(c.getFromDate()), LocalDate.parse(c.getToDate()));
            c.setNumberOfDays(period.getDays());

            assignContract(c); // assigns car and customer to list. We use it to calculate price
            assignPrice(c);//assigns distance and price based on amount of days
            c.setMaxKM(c.getNumberOfDays() * 400); //assigns max km

            //Inserts into database
            String sql = "INSERT INTO contracts() VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, c.getId(), c.getFromDate(), c.getToDate(), c.getNumberOfDays(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice(), c.getStaff());

            //inserts into intermediary table between accessories and contracts.
            for(int i = 0; i < accessory.length; i++){
                    sql = "INSERT INTO accessory_contract () VALUES (?,?)";
                    template.update(sql, accessory[i], c.getId());
            }
            return null;
        /*} catch(Exception e) {

        }*/
    }

    public Contract findById(int id) {
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price, staff FROM contracts c JOIN customers cust ON c.customId = cust.id JOIN motorhomes m ON c.carId = m.licensePlate WHERE c.id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract contract = template.queryForObject(sql, rowMapper, id);

        contract.setAccessoryList(assignContractAccessories(contract));
        assignContract(contract); //Assigns the contract we just retrieved a customer and vehicle.

        return contract;
    }

    public Boolean delete(int id) {
        try{
            String sql = "DELETE FROM contracts WHERE id = ?";
            template.update(sql, id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Contract update(Contract c, int[] accessories) {
        String sql = "DELETE FROM accessory_contract WHERE contract_id = ?"; //deletes all. easier if we want to remove some accessories
        template.update(sql, c.getId());

        for(int i = 0; i < accessories.length; i++){
            sql = "INSERT INTO accessory_contract () VALUES (?, ?)";
            template.update(sql, accessories[i], c.getId());
        }

        sql = "UPDATE contracts c SET fromDate = ?, toDate = ?, numberOfDays = ?, carId = ?, customId = ?, maxKM = ?, price = ?, staff = ? WHERE id = ?";
        template.update(sql, c.getFromDate(), c.getToDate(), c.getNumberOfDays(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice(), c.getStaff(), c.getId());
        return null;
    }

    public void assignContract(Contract contract){
        contract.setCustomer(customerRepository.findById(contract.getCustomId()));
        contract.setMotorhome(motorhomeRepository.findById(contract.getCarId()));
    }

    public void assignPrice(Contract contract){
        contract.setMaxKM(contract.getNumberOfDays() * 400);

        //For loop so it makes  sure that it calculates correct price if rental is ongoing in different seasons
        for(int i = 0; i < contract.getNumberOfDays(); i++){
            Season season = seasonRepository.findByDate(LocalDate.parse(contract.getFromDate()).plusDays(i+1)); //det virker til at den tager datoen for dagen før vores fromdate, så vi + 1
            int carPrice = contract.getMotorhome().getPricePerDay();

            if(season.getType().equals("High")){
                carPrice *= 1.60;
            }else if(season.getType().equals("Middle")){
                carPrice *= 1.30;
            }else{
                carPrice *= 1;
            }
            contract.setPrice(contract.getPrice() + carPrice);
        }
        if(contract.getAccessoryList()!=null || contract.getAccessoryList().size() != 0) {
            for (int i = 0; i < contract.getAccessoryList().size(); i++) {
                contract.setPrice(contract.getPrice() + contract.getAccessoryList().get(i).getPrice());
            }
        }
    }

    public List<Accessory> assignContractAccessories(Contract c){
        String sql = "SELECT a.id, a.name, a.amount_available, a.amount_total, a.price FROM accessory_contract ac JOIN accessories a ON ac.accessory_id = a.id JOIN contracts c ON ac.contract_id = c.id WHERE c.id = ?";
        RowMapper<Accessory> rowMapper = new BeanPropertyRowMapper<>(Accessory.class);
        List<Accessory> accessoryList = template.query(sql, rowMapper, c.getId());

        return accessoryList;
    }
}
