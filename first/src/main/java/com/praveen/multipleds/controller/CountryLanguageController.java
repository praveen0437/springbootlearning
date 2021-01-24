package com.praveen.multipleds.controller;

import com.praveen.multipleds.country.CountryLanguage;
import com.praveen.multipleds.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryLanguageController {
    @Autowired
    private CountryLanguageService countryLanguageService;

    @GetMapping("/countryLang")
    public List<CountryLanguage> list() {
    return countryLanguageService.listAll();
    }
}
