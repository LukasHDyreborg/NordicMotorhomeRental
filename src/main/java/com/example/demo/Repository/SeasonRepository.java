package com.example.demo.Repository;

import com.example.demo.Model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class SeasonRepository {

    @Autowired
    JdbcTemplate template;

    public List<Season> fetchAll(){
        String sql = "SELECT * FROM seasons ORDER BY id";
        RowMapper<Season> rowMapper = new BeanPropertyRowMapper<>(Season.class);
        return template.query(sql, rowMapper);
    }

    public Season findById(int id){
        String sql = "SELECT * FROM seasons WHERE id = ?";
        RowMapper<Season> rowMapper = new BeanPropertyRowMapper<>(Season.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public boolean add(Season s){
        try{
            String sql = "INSERT INTO seasons() VALUES (DEFAULT, ?, ?, ?)";
            template.update(sql, s.getStart_date(), s.getEnd_date(), s.getType());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Season update(Season s){
        String sql = "UPDATE seasons SET start_date = ?, end_date = ?, `type` = ? WHERE id = ?";
        template.update(sql, s.getStart_date(), s.getEnd_date(), s.getType(), s.getId());
        return null;
    }

    public Boolean delete(int id){
        try{
            String sql = "DELETE FROM seasons WHERE id = ?";
            template.update(sql, id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Season findByDate(LocalDate localDate){
        String sql = "SELECT * FROM seasons WHERE ? BETWEEN start_date AND end_date";
        RowMapper<Season> rowMapper = new BeanPropertyRowMapper<>(Season.class);
        return template.queryForObject(sql, rowMapper, localDate);
    }
}
