package com.example.demo.Repository;

import com.example.demo.Model.Luxury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

// Lavet af LHD

@Repository
public class LuxuryRepository {
    @Autowired
    JdbcTemplate template;

    public List<Luxury> fetchAll() {
        String sql = "SELECT * FROM motorhomes m JOIN standard s ON m.licensePlate = s.licensePlate JOIN luxury l ON m.licensePlate = l.licensePlate;";
        RowMapper<Luxury> rowMapper = new BeanPropertyRowMapper<>(Luxury.class);
        return template.query(sql, rowMapper);
    }

    public Luxury add(Luxury l) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, " +
                "registrationDate, lengthAndHeight, `type`, fridge, toilet, awning) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, l.getLicensePlate(), l.getBrand(), l.getModel(), l.getPricePerDay(), l.getSeats(), l.getBeds(), l.getFuelType(), l.getGear(), l.getOdometer(),
                l.getRegistrationDate(), l.getLengthAndHeight(), l.getType(), l.isFridge(), l.isToilet(), l.isAwning());

        String sql = "INSERT INTO standard(licensePlate, shower, elStove) VALUES (?, ?, ?)";
        template.update(sql, l.getLicensePlate(), l.isShower(), l.isElStove());

        sql = "INSERT INTO luxury(licensePlate, tv, rearviewCamera) VALUES (?, ?, ?)";
        template.update(sql, l.getLicensePlate(), l.isTv(), l.isRearViewCamera());
        return null;
    }

    public Luxury findById(String id) {
        String sql = "SELECT * FROM motorhomes m JOIN standard s ON m.licensePlate = s.licensePlate JOIN luxury l ON m.licensePlate = l.licensePlate WHERE m.licensePlate = ?";
        RowMapper<Luxury> rowMapper = new BeanPropertyRowMapper<>(Luxury.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean delete(String id) {
        try {
            String sql = "DELETE FROM luxury WHERE licensePlate = ?";
            template.update(sql, id);

            sql = "DELETE FROM standard WHERE licensePlate = ?";
            template.update(sql, id);

            sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
            template.update(sql, id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Luxury update(Luxury l, String licensePlate) {
        String sql = "UPDATE luxury SET tv = ?, rearViewCamera = ? WHERE licensePlate = ?";
        template.update(sql, l.isTv(), l.isRearViewCamera(), l.getLicensePlate());

        sql = "UPDATE standard SET shower = ?, elStove = ? WHERE licensePlate = ?";
        template.update(sql, l.isShower(), l.isElStove(), l.getLicensePlate());

        sql = "UPDATE motorhomes SET licensePlate = ?, brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, " +
                "registrationDate = ?, lengthAndHeight = ?, `type` = ?, fridge = ?, toilet = ?, awning = ? WHERE licensePlate = ?";
        template.update(sql, l.getLicensePlate(), l.getBrand(), l.getModel(), l.getPricePerDay(), l.getSeats(), l.getBeds(), l.getFuelType(), l.getGear(), l.getOdometer(),
                l.getRegistrationDate(), l.getLengthAndHeight(), l.getType(), l.isFridge(), l.isToilet(), l.isAwning(), licensePlate);
        return null;
    }
}