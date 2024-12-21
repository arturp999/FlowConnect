package com.flow.connect.configurations.dbs.datasources;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.flow-connect")
@Data
public class FlowConnectDataSourceConfig {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Primary
    @Bean(name = "flowConnectDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @PostConstruct
    public void checkDataSource() {
        System.out.println("Datasource created: " + url);
    }

}
