package com.example.demo.Service;

import com.example.demo.Model.Season;
import com.example.demo.Repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    @Autowired
    SeasonRepository seasonRepository;

    public List<Season> fetchAll(){return seasonRepository.fetchAll();}

    public Season findById(int id){return seasonRepository.findById(id);}

    public boolean add(Season s){return seasonRepository.add(s);}

    public Season update(Season s){return seasonRepository.update(s);}

    public boolean delete(int id){return seasonRepository.delete(id);}
}
