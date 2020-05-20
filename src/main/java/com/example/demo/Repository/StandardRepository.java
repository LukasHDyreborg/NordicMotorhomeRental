package com.example.demo.Repository;

import com.example.demo.Model.Economy;
import com.example.demo.Model.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StandardRepository {
    @Autowired
    JdbcTemplate template;

    public List<Standard> fetchAll() {
        String sql = "SELECT * FROM motorhomes m JOIN standard s ON m.licensePlate = s.licensePlate)";
        RowMapper<Standard> rowMapper = new BeanPropertyRowMapper<>(Standard.class);
        return template.query(sql, rowMapper);
    }

    public Standard addStandard(Standard s) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, registrationDate, lengthAndHeight, `type`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, s.getLicensePlate(), s.getBeds(), s.getModel(), s.getPricePerDay(), s.getSeats(), s.getBeds(), s.getFuelType(), s.getGear(), s.getOdometer(), s.getRegistrationDate(), s.getLengthAndHeight(), s.getType());

        String sql = "INSERT INTO standard(licensePlate, fridge, toilet, shower, elStove, awning, tv, rearViewCamera) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, s.getLicensePlate(), s.isFridge(), s.isToilet(), s.isShower(), s.isElStove(), s.isAwning(), s.isTv(), s.isRearViewCamera());
        return null;
    }

    public Standard findStandardById(int id) {
        String sql = "SELECT * FROM motorhomes m JOIN standard s ON m.licensePlate = s.licensePlate WHERE m.licensePlate = ?";
        RowMapper<Standard> rowMapper = new BeanPropertyRowMapper<>(Standard.class);
        Standard s = template.queryForObject(sql, rowMapper, id);
        return s;
    }

    public Boolean deleteStandard(int id) {
        String sql = "DELETE FROM standard WHERE licensePlate = ?";
        template.update(sql, id);

        sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
        return template.update(sql, id) < 0;
    }

    public Standard updateStandard(Standard s) {
        String sql = "UPDATE standard SET fridge = ?, toilet = ?, shower = ?, elStove, awning = ?, tv = ?, rearViewCamera = ? WHERE licensePlate = ?";
        template.update(sql, s.isFridge(), s.isToilet(), s.isShower(), s.isElStove(), s.isAwning(), s.isTv(), s.isRearViewCamera(), s.getLicensePlate());

        sql = "UPDATE motorhomes SET brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, registrationDate = ?, lengthAndHeight = ?, `type` = ? WHERE licensePlate = ?";
        template.update(sql, s.getBeds(), s.getModel(), s.getPricePerDay(), s.getSeats(), s.getBeds(), s.getFuelType(), s.getGear(), s.getOdometer(), s.getRegistrationDate(), s.getLengthAndHeight(), s.getType(), s.getLicensePlate());
        return null;
    }
}
