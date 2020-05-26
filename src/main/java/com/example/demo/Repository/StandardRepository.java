package com.example.demo.Repository;

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
        //Luxury og standard deler table for standard information. Derfor sikrer vi at vi ikke tage en luxyry med i fetchall ved at sige license plate not in licenseplates i luxury
        String sql = "SELECT * FROM motorhomes m JOIN standard s ON m.licensePlate = s.licensePlate WHERE m.licensePlate NOT IN (SELECT licensePlate FROM luxury)";
        RowMapper<Standard> rowMapper = new BeanPropertyRowMapper<>(Standard.class);
        return template.query(sql, rowMapper);
    }

    public Standard add(Standard s) {
        String morhomeSql = "INSERT INTO motorhomes(licensePlate, brand, model, pricePerDay, seats, beds, fuelType, gear, odometer, " +
                "registrationDate, lengthAndHeight, `type`, fridge, toilet, awning) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(morhomeSql, s.getLicensePlate(), s.getBrand(), s.getModel(), s.getPricePerDay(), s.getSeats(), s.getBeds(),
                s.getFuelType(), s.getGear(), s.getOdometer(), s.getRegistrationDate(), s.getLengthAndHeight(), s.getType(), s.isFridge(), s.isToilet(), s.isAwning());

        String sql = "INSERT INTO standard(licensePlate, shower, elStove) VALUES (?, ?, ?)";
        template.update(sql, s.getLicensePlate(), s.isShower(), s.isElStove());
        return null;
    }

    public Standard findById(String id) {
        String sql = "SELECT * FROM motorhomes m JOIN standard s ON m.licensePlate = s.licensePlate WHERE m.licensePlate = ? AND m.licensePlate NOT IN (SELECT licensePlate FROM luxury)";
        RowMapper<Standard> rowMapper = new BeanPropertyRowMapper<>(Standard.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean delete(String id) {
        try{
            String sql = "DELETE FROM standard WHERE licensePlate = ?";
            template.update(sql, id);

            sql = "DELETE FROM motorhomes WHERE licensePlate = ?";
            template.update(sql, id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Standard update(Standard s, String licensePlate) {
        String sql = "UPDATE standard SET shower = ?, elStove = ? WHERE licensePlate = ?";
        template.update(sql, s.isShower(), s.isElStove(), s.getLicensePlate());

        sql = "UPDATE motorhomes SET licensePlate = ?, brand = ?, model = ?, pricePerDay = ?, seats = ?, beds = ?, fuelType = ?, gear = ?, odometer = ?, " +
                "registrationDate = ?, lengthAndHeight = ?, `type` = ?, fridge = ?, toilet = ?, awning = ? WHERE licensePlate = ?";
        template.update(sql, s.getLicensePlate(), s.getBrand(), s.getModel(), s.getPricePerDay(), s.getSeats(), s.getBeds(), s.getFuelType(), s.getGear(), s.getOdometer(),
                s.getRegistrationDate(), s.getLengthAndHeight(), s.getType(), s.isFridge(), s.isToilet(), s.isAwning(), licensePlate);
        return null;
    }
}
