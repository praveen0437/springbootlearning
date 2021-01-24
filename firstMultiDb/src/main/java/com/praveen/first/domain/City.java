package com.praveen.first.domain;

import javax.persistence.*;

@Entity
public class City {
    private Integer iD;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;

public City() {
}

public City(Integer id, String name, String countryCode, String district, Integer population) {
    this.iD = id;
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }


}