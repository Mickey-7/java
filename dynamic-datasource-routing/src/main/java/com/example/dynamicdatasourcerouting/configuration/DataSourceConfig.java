package com.example.dynamicdatasourcerouting.configuration;

import com.example.dynamicdatasourcerouting.component.BangkokDetails;
import com.example.dynamicdatasourcerouting.component.HongkongDetails;
import com.example.dynamicdatasourcerouting.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        //package of the repository
        basePackages = "com.example.dynamicdatasourcerouting.repository",
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {
    @Autowired
    private BangkokDetails bangkokDetails;
    @Autowired
    private HongkongDetails hongkongDetails;

    public DataSource bangkokDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(bangkokDetails.getUrl());
        dataSource.setUsername(bangkokDetails.getUsername());
        dataSource.setPassword(bangkokDetails.getPassword());
        return dataSource;

    }
    public DataSource hongkongDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(hongkongDetails.getUrl());
        dataSource.setUsername(hongkongDetails.getUsername());
        dataSource.setPassword(hongkongDetails.getPassword());
        return dataSource;

    }

    @Bean
    @Primary
    @Autowired
    public DataSource dataSource(){
        DataSourceRouting routingDataSource = new DataSourceRouting();
        routingDataSource.initDatasource(bangkokDataSource(), hongkongDataSource());
        return routingDataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource()).packages(Employee.class).build();
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(
            @Autowired
            @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
