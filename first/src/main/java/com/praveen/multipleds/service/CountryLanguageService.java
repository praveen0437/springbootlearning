package com.praveen.multipleds.service;

import com.praveen.multipleds.country.CountryLanguage;
import com.praveen.multipleds.country.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional(value="countryLangTransactionManager")
@Transactional
public class CountryLanguageService {
    @Autowired
    private CountryLanguageRepository repo;

    public List<CountryLanguage> listAll() {
        return repo.findAll();
    }

    public void save(CountryLanguage city) {
        repo.save(city);
    }

//   // public City get(CountryLanguageId id) {
//        return repo.findById(id.getCountryCode(),id.getLanguage()).get();
//    }

//    public void delete(CountryLanguageId id) {
//        repo.deleteById(id);
//    }
}
