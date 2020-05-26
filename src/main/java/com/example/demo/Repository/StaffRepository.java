package com.example.demo.Repository;

import com.example.demo.Model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepository {

    @Autowired
    JdbcTemplate template;

    public List<Staff> fetchAll(){
        String sql = "SELECT * FROM staffs ORDER BY id";
        RowMapper<Staff> rowMapper = new BeanPropertyRowMapper<>(Staff.class);
        return template.query(sql, rowMapper);
    }

    public Staff findById(int id){
        String sql = "SELECT * FROM staffs WHERE id = ?";
        RowMapper<Staff> rowMapper = new BeanPropertyRowMapper<>(Staff.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public boolean add(Staff s){
        try{
            String sql = "INSERT INTO staffs() VALUES (DEFAULT, ?, ?)";
            template.update(sql, s.getName(), s.getInitials());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Staff update(Staff s){
        String sql = "UPDATE staffs SET `name` = ?, initials = ? WHERE id = ?";
        template.update(sql, s.getName(), s.getInitials(), s.getId());
        return null;
    }

    public Boolean delete(int id){
        try{
            String sql = "DELETE FROM staffs WHERE id = ?";
            template.update(sql, id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
