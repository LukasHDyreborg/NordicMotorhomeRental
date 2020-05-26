package com.example.demo.Repository;

import com.example.demo.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepository {
    @Autowired
    JdbcTemplate template;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MotorhomeRepository motorhomeRepository;

    public List<Contract> fetchAll() {
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price FROM contracts c JOIN customers cust ON c.customId = cust.id JOIN motorhomes m ON c.carId = m.licensePlate ORDER BY c.id";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        List<Contract> contractList = template.query(sql, rowMapper);

        //assigns customer and vehicle to contract
        for(int i = 0; i < contractList.size(); i++){
            assignContract(contractList.get(i));
        }
        return contractList;
    }

    public Contract add(Contract c) {
        /*try{*/
            assignContract(c);//assigns distance and price based on amount of days, also customer and motorhome assignment

            String sql = "INSERT INTO contracts() VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, c.getFromDate(), c.getToDate(), c.getNumberOfDays(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice());
            return null;
        /*} catch(Exception e) {

        }*/
    }

    public Contract findById(int id) {
        String sql = "SELECT c.id, fromDate, toDate, numberOfDays, carId, customId, maxKM, price FROM contracts c JOIN customers cust ON c.customId = cust.id JOIN motorhomes m ON c.carId = m.licensePlate WHERE c.id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract contract = template.queryForObject(sql, rowMapper, id);

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

    public Contract update(Contract c) {
        String sql = "UPDATE contracts c SET fromDate = ?, toDate = ?, numberOfDays = ?, carId = ?, customId = ?, maxKM = ?, price = ? WHERE id = ?";
        template.update(sql, c.getFromDate(), c.getToDate(), c.getNumberOfDays(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice(), c.getId());
        return null;
    }

    public void assignContract(Contract contract){
        contract.setCustomer(customerRepository.findById(contract.getCustomId()));
        contract.setMotorhome(motorhomeRepository.findById(contract.getCarId()));

        if(contract.getMaxKM() == 0) {
            contract.setMaxKM(contract.getNumberOfDays() * 400);
        }

        if(contract.getPrice() == 0){
            contract.setPrice(contract.getMotorhome().getPricePerDay() * contract.getNumberOfDays());
        }
    }
}
