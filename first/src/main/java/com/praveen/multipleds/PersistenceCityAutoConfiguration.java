package com.praveen.multipleds;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.praveen.multipleds.city", entityManagerFactoryRef = "cityEntityManager", transactionManagerRef = "cityTransactionManager")
public class PersistenceCityAutoConfiguration {
    public PersistenceCityAutoConfiguration() {
        super();
    }

    //

    @Bean(name="cityEntityManager")
    public LocalContainerEntityManagerFactoryBean cityEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(cityDataSource());
        em.setPackagesToScan("com.praveen.multipleds.city");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);


        return em;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.second-datasource")
    public DataSource cityDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cityTransactionManager")
    public PlatformTransactionManager cityTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(cityEntityManager().getObject());
        return transactionManager;
    }

}
