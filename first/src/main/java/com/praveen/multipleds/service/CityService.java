package com.praveen.multipleds.service;

import com.praveen.multipleds.city.City;
import com.praveen.multipleds.city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional( value="cityTransactionManager")
public class CityService {

    @Autowired
    private CityRepository repo;

    public List<City> listAll() {
        return repo.findAll();
    }

    public void save(City city) {
        repo.save(city);
    }

    public City get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
