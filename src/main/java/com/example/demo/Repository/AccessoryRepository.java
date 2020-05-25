package com.example.demo.Repository;

import com.example.demo.Model.Accessory;
import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccessoryRepository {

    @Autowired
    JdbcTemplate template;

    public List<Accessory> fetchAll() {
        String sql = "SELECT * FROM accessories ORDER BY id";
        RowMapper<Accessory> rowMapper = new BeanPropertyRowMapper<>(Accessory.class);
        return template.query(sql, rowMapper);
    }

    public Accessory findById(int id) {
        String sql = "SELECT * FROM accessories WHERE id = ?";
        RowMapper<Accessory> rowMapper = new BeanPropertyRowMapper<>(Accessory.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public boolean add(Accessory a) {
        try {
            String sql = "INSERT INTO accessories() VALUES (DEFAULT, ?, ?, ?, ?)";
            template.update(sql, a.getName(), a.getAmountAvailable(), a.getAmountTotal(), a.getPrice());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Accessory update(Accessory a) {
        String sql = "UPDATE accessories SET `name` = ?, amount_available = ?, amount_total = ?, price = ? WHERE id = ?";
        template.update(sql, a.getName(), a.getAmountAvailable(), a.getAmountTotal(), a.getPrice(), a.getId());
        return null;
    }

    public Boolean delete(int id) {
        try {
            String sql = "DELETE FROM accessories WHERE id = ?";
            template.update(sql, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}