package com.flow.connect.configurations.dbs.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.flow.connect.repository.communicationhub", 
    entityManagerFactoryRef = "communicationHubEntityManagerFactory", 
    transactionManagerRef = "communicationHubTransactionManager"
)
@EnableTransactionManagement
public class CommunicationHubJpaConfig {

    @Bean(name = "communicationHubEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("communicationHubDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.flow.connect.repository.communicationhub");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean;
    }

    @Bean(name = "communicationHubTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("communicationHubDataSource") DataSource dataSource) {
        return new JpaTransactionManager(entityManagerFactory(dataSource).getObject());
    }
}
