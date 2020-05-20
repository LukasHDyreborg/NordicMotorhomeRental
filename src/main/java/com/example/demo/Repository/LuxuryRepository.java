package com.example.demo.Repository;

import com.example.demo.Model.Luxury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LuxuryRepository {
    @Autowired
    JdbcTemplate template;

    public List<Luxury> fetchAll() {
        String sql = "SELECT * FROM motorhomes m JOIN luxury l ON m.licensePlate = l.licensePlate)";
        RowMapper<Luxury> rowMapper = new BeanPropertyRowMapper<>(Luxury.class);
        return template.query(sql, rowMapper);
    }

    public Luxury addLuxury(Luxury l) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, `type`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, l.getLicensePlate(), l.getBeds(), l.getModel(), l.getPricePerDay(), l.getSeats(), l.getBeds(), l.getFuelType(), l.getGear(), l.getOdometer(), l.getRegistrationDate(), l.getLengthAndHeight(), l.getType());

        String sql = "INSERT INTO standard(licensePlate, fridge, toilet, shower, elStove, awning, tv, rearViewCamera) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, l.getLicensePlate(), l.isFridge(), l.isToilet(), l.isShower(), l.isElStove(), l.isAwning(), l.isTv(), l.isRearViewCamera());
        return null;
    }

    public Luxury findLuxuryById(int id) {
        String sql = "SELECT * FROM motorhomes m JOIN luxury l ON m.licensePlate = l.licensePlate WHERE m.licensePlate = ?";
        RowMapper<Luxury> rowMapper = new BeanPropertyRowMapper<>(Luxury.class);
        Luxury l = template.queryForObject(sql, rowMapper, id);
        return l;
    }

    public Boolean deleteLuxury(int id) {
        String sql = "DELETE FROM luxury WHERE licensePlate = ?";
        template.update(sql, id);

        sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
        return template.update(sql, id) < 0;
    }

    public Luxury updateLuxury(Luxury l) {
        String sql = "UPDATE luxury SET fridge = ?, toilet = ?, shower = ?, elStove, awning = ?, tv = ?, rearViewCamera = ? WHERE licensePlate = ?";
        template.update(sql, l.isFridge(), l.isToilet(), l.isShower(), l.isElStove(), l.isAwning(), l.isTv(), l.isRearViewCamera(), l.getLicensePlate());

        sql = "UPDATE motorhomes SET brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, registrationDate = ?, lengthAndHeight = ?, `type` = ? WHERE licensePlate = ?";
        template.update(sql, l.getBeds(), l.getModel(), l.getPricePerDay(), l.getSeats(), l.getBeds(), l.getFuelType(), l.getGear(), l.getOdometer(), l.getRegistrationDate(), l.getLengthAndHeight(), l.getType(), l.getLicensePlate());
        return null;
    }
}