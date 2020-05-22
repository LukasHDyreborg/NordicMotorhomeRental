package com.example.demo.Repository;

import com.example.demo.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepository {
    @Autowired
    JdbcTemplate template;

    public Contract fetchAll() {
        String sql = "SELECT * FROM contracts contract JOIN customers customer ON customer.id = contract.id JOIN motorhomes motorhome ON motorhome.licensePlate = contract.id";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    public Contract add(Contract c) {
        return null;
    }

    public Contract findById(int id) {
        return null;
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM contract WHERE id = ?";
        return template.update(sql, id) < 0;
    }

    public Contract update(Contract c) {
        return null;
    }
}
