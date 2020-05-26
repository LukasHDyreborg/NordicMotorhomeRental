package com.example.demo.Service;

import com.example.demo.Model.Staff;
import com.example.demo.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public List<Staff> fetchAll(){return staffRepository.fetchAll();}

    public Staff findById(int id){return staffRepository.findById(id);}

    public boolean add(Staff s){return staffRepository.add(s);}

    public Staff update(Staff s){return staffRepository.update(s);}

    public boolean delete(int id){return staffRepository.delete(id);}
}
