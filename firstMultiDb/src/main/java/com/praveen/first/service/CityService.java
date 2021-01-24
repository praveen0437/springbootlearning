package com.praveen.first.service;

import com.praveen.first.domain.City;
import com.praveen.first.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
