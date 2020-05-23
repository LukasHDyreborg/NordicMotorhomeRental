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

    public List<Contract> fetchAll() {
        String sql = "SELECT c.id, fromDate, toDate, carId, customId, maxKM, price FROM contracts c JOIN customers cust ON c.customId = cust.id JOIN motorhomes m ON c.carId = m.licensePlate ORDER BY c.id";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    public Contract add(Contract c) {
        /*try{*/
            String sql = "INSERT INTO contracts() VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
            template.update(sql, c.getFromDate(), c.getToDate(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice());
            return null;
        /*} catch(Exception e) {

        }*/
    }

    public Contract findById(int id) {
        String sql = "SELECT c.id, fromDate, toDate, carId, customId, maxKM, price FROM contracts c JOIN customers cust ON c.customId = cust.id JOIN motorhomes m ON c.carId = m.licensePlate WHERE c.id = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.queryForObject(sql, rowMapper, id);
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
        String sql = "UPDATE contracts c SET fromDate = ?, toDate = ?, carId = ?, customId = ?, maxKM = ?, price = ? WHERE id = ?";
        template.update(sql, c.getFromDate(), c.getToDate(), c.getCarId(), c.getCustomId(), c.getMaxKM(), c.getPrice(), c.getId());
        return null;
    }
}
