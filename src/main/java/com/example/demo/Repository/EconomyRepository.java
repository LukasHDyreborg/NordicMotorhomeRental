package com.example.demo.Repository;

import com.example.demo.Model.Economy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EconomyRepository {
    @Autowired
    JdbcTemplate template;

    public List<Economy> fetchAll() {
        String sql = "SELECT * FROM motorhomes m JOIN economy e ON m.licensePlate = e.licensePlate";
        RowMapper<Economy> rowMapper = new BeanPropertyRowMapper<>(Economy.class);
        return template.query(sql, rowMapper);
    }

    public Economy add(Economy e) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, `type`, fridge, toilet, awning) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, e.getLicensePlate(), e.getBrand(), e.getModel(), e.getPricePerDay(), e.getSeats(), e.getBeds(), e.getFuelType(), e.getGear(), e.getOdometer(), e.getRegistrationDate(), e.getLengthAndHeight(), e.getType(), e.isFridge(), e.isToilet(), e.isAwning());

        String sql = "INSERT INTO economy(licensePlate, gasBurners) VALUES (?, ?)";
        template.update(sql, e.getLicensePlate(), e.getGasBurners());
        return null;
    }

    public Economy findById(String id) {
        String sql = "SELECT * FROM motorhomes m JOIN economy e ON m.licensePlate = e.licensePlate WHERE m.licensePlate = ?";
        RowMapper<Economy> rowMapper = new BeanPropertyRowMapper<>(Economy.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean delete(String id) {
        try{
            String sql = "DELETE FROM economy WHERE licensePlate = ?";
            template.update(sql, id);

            sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
            template.update(sql, id);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Economy update(Economy e, String licensePlate) {
        String sql = "UPDATE economy SET gasBurners = ? WHERE licensePlate = ?";
        template.update(sql, e.getGasBurners(), e.getLicensePlate());

        sql = "UPDATE motorhomes SET licensePlate = ?, brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, registrationDate = ?, lengthAndHeight = ?, `type` = ?, fridge = ?, toilet = ?, awning = ? WHERE licensePlate = ?";
        template.update(sql, e.getLicensePlate(), e.getBrand(), e.getModel(), e.getPricePerDay(), e.getSeats(), e.getBeds(), e.getFuelType(), e.getGear(), e.getOdometer(), e.getRegistrationDate(), e.getLengthAndHeight(), e.getType(), e.isFridge(), e.isToilet(), e.isAwning(), licensePlate);
        return null;
    }
}
