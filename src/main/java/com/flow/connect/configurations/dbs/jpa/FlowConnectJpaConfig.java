package com.flow.connect.configurations.dbs.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.flow.connect.repository.flowconnect", 
    entityManagerFactoryRef = "flowConnectEntityManagerFactory", 
    transactionManagerRef = "flowConnectTransactionManager"
)
public class FlowConnectJpaConfig {
    
    @Bean(name = "flowConnectEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("flowConnectDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.flow.connect.repository.flowconnect");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean;
    }

    @Bean(name = "flowConnectTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("flowConnectDataSource") DataSource dataSource) {
        return new JpaTransactionManager(entityManagerFactory(dataSource).getObject());
    }
}
