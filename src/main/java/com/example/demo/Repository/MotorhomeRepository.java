package com.example.demo.Repository;

import com.example.demo.Model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepository {
    @Autowired
    JdbcTemplate template;

    public List<Motorhome> fetchAll() {
        String sql = "SELECT * FROM motorhomes;";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper);
    }

    public Motorhome add(Motorhome m) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, " +
                "registrationDate, lengthAndHeight, `type`, fridge, toilet, awning) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, m.getLicensePlate(), m.getBrand(), m.getModel(), m.getPricePerDay(), m.getSeats(), m.getBeds(), m.getFuelType(), m.getGear(), m.getOdometer(),
                m.getRegistrationDate(), m.getLengthAndHeight(), m.getType(), m.isFridge(), m.isToilet(), m.isAwning());

        return null;
    }

    public Motorhome findById(int id) {
        String sql = "SELECT * FROM motorhomes WHERE licensePlate = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
        return template.update(sql, id) < 0;
    }

    public Motorhome update(Motorhome m) {
        String sql = "UPDATE motorhomes SET brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, " +
                "registrationDate = ?, lengthAndHeight = ?, `type` = ?, fridge = ?, toilet = ?, awning = ? WHERE licensePlate = ?";
        template.update(sql, m.getBrand(), m.getModel(), m.getPricePerDay(), m.getSeats(), m.getBeds(), m.getFuelType(), m.getGear(), m.getOdometer(),
                m.getRegistrationDate(), m.getLengthAndHeight(), m.getType(), m.isFridge(), m.isToilet(), m.isAwning(), m.getLicensePlate());
        return null;
    }
}