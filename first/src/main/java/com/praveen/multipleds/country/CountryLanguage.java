package com.praveen.multipleds.country;

import javax.persistence.*;

@Entity
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId countryLanguageId;
    private String isOfficial;
    private Double percentage;

public CountryLanguage() {
}

public CountryLanguage( CountryLanguageId countryLanguageId, String isOfficial, Double percentage) {
    this.countryLanguageId = countryLanguageId;
    this.isOfficial = isOfficial;
    this.percentage = percentage;
}

    public CountryLanguageId getCountryLanguageId() {
        return countryLanguageId;
    }

    public void setCountryLanguageId(CountryLanguageId countryLanguageId) {
        this.countryLanguageId = countryLanguageId;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}