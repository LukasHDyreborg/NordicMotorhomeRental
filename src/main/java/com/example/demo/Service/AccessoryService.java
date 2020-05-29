package com.example.demo.Service;

import com.example.demo.Model.Accessory;
import com.example.demo.Repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    AccessoryRepository AccessoryRepository;

    public List<Accessory> fetchAll(){
        return AccessoryRepository.fetchAll();
    }
    public List<Accessory> fetchAllAvailable(){
        return AccessoryRepository.fetchAllAvailable();
    }
    public Accessory findById(int id){
        return AccessoryRepository.findById(id);
    }

    public boolean add(Accessory a){
        return AccessoryRepository.add(a);
    }

    public Accessory update(Accessory a){
        return AccessoryRepository.update(a);
    }

    public Boolean delete(int id){
        return AccessoryRepository.delete(id);
    }
}