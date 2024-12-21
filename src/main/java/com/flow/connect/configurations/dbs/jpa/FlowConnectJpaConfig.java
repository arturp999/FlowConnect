package com.flow.connect.configurations.dbs.jpa;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.flow.connect.repository.flowconnect", 
    entityManagerFactoryRef = "flowConnectEntityManagerFactory", 
    transactionManagerRef = "flowConnectTransactionManager"
)
public class FlowConnectJpaConfig {
    // Configuration for repositories using flow_connect DB
}
