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
        String sql = "SELECT * FROM motorhomes m JOIN economy e ON m.licensePlate = e.licensePlate)";
        RowMapper<Economy> rowMapper = new BeanPropertyRowMapper<>(Economy.class);
        return template.query(sql, rowMapper);
    }

    public Economy addEconomy(Economy e) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, `type`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, e.getLicensePlate(), e.getBeds(), e.getModel(), e.getPricePerDay(), e.getSeats(), e.getBeds(), e.getFuelType(), e.getGear(), e.getOdometer(), e.getRegistrationDate(), e.getLengthAndHeight(), e.getType());

        String sql = "INSERT INTO economy(licensePlate, fridge, toilet, gasBurners, awning) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, e.getLicensePlate(), e.isFridge(), e.isToilet(), e.getGasBurners(), e.isAwning());
        return null;
    }

    public Economy findEconomyById(int id) {
        String sql = "SELECT * FROM motorhomes m JOIN economy e ON m.licensePlate = f.licensePlate WHERE c.licensePlate = ?";
        RowMapper<Economy> rowMapper = new BeanPropertyRowMapper<>(Economy.class);
        Economy e = template.queryForObject(sql, rowMapper, id);
        return e;
    }

    public Boolean deleteEconomy(int id) {
        String sql = "DELETE FROM economy WHERE licensePlate = ?";
        template.update(sql, id);

        sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
        return template.update(sql, id) < 0;
    }

    public Economy updateEconomy(Economy e) {
        String sql = "UPDATE economy SET fridge = ?, toilet = ?, gasBurners = ?, awning = ? WHERE licensePlate = ?";
        template.update(sql, e.isFridge(), e.isToilet(), e.getGasBurners(), e.isAwning(), e.getLicensePlate());

        sql = "UPDATE motorhomes SET brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, registrationDate = ?, lengthAndHeight = ?, `type` = ? WHERE licensePlate = ?";
        template.update(sql, e.getBeds(), e.getModel(), e.getPricePerDay(), e.getSeats(), e.getBeds(), e.getFuelType(), e.getGear(), e.getOdometer(), e.getRegistrationDate(), e.getLengthAndHeight(), e.getType(), e.getLicensePlate());
        return null;
    }
}
