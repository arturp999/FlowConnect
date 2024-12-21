package com.flow.connect.configurations.dbs.jpa;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.flow.connect.repository.communicationhub", 
    entityManagerFactoryRef = "communicationHubEntityManagerFactory", 
    transactionManagerRef = "communicationHubTransactionManager"
)
public class CommunicationHubJpaConfig {
    // Configuration for repositories using communication_hub DB
}
