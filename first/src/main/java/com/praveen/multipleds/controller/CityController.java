package com.praveen.multipleds.controller;

import com.praveen.multipleds.city.City;
import com.praveen.multipleds.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/citys")
    public List<City> list() {
    return cityService.listAll();
    }
}
