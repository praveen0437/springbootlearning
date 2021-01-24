package com.praveen.multipleds;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.praveen.multipleds.country", entityManagerFactoryRef = "countryLangEntityManager", transactionManagerRef = "countryLangTransactionManager")
public class PersistenceCountryLanguageAutoConfiguration {
    public PersistenceCountryLanguageAutoConfiguration() {
        super();
    }

    //

    @Primary
    @Bean(name="countryLangEntityManager")
    public LocalContainerEntityManagerFactoryBean countryLangEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(countryLangDataSource());
        em.setPackagesToScan("com.praveen.multipleds.country");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);


        return em;
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource countryLangDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "countryLangTransactionManager")
    @Primary
    public PlatformTransactionManager countryLangTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(countryLangEntityManager().getObject());
        return transactionManager;
    }

}
