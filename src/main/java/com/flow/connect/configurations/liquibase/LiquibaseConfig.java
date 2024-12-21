package com.flow.connect.configurations.liquibase;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    // Liquibase for 'flow-connect' database
    @Bean
    public SpringLiquibase liquibaseFlowConnect(@Qualifier("flowConnectDataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/flow-connect/changelog/flow-connect-changelog.yaml");
        liquibase.setDatabaseChangeLogTable("DATABASECHANGELOG_FLOW_CONNECT");
        liquibase.setDropFirst(false);
        return liquibase;
    }

    // Transaction manager for 'flow-connect' database
    @Bean
    public PlatformTransactionManager transactionManagerFlowConnect(@Qualifier("flowConnectDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    
    
    // Liquibase for 'communication-hub' database
    @Bean
    public SpringLiquibase liquibaseCommunicationHub(@Qualifier("communicationHubDataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/communication-hub/changelog/communication-hub-changelog.yaml");
        liquibase.setDatabaseChangeLogTable("DATABASECHANGELOG_COMMUNICATION_HUB");
        liquibase.setDropFirst(false);
        return liquibase;
    }

    // Transaction manager for 'communication-hub' database
    @Bean
    public PlatformTransactionManager transactionManagerCommunicationHub(@Qualifier("communicationHubDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

