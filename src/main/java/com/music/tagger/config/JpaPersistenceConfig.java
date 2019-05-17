package com.music.tagger.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;

import static java.util.Objects.requireNonNull;
/*
@Configuration
//@EnableJpaRepositories(basePackages = {"com.music.tagger.persistence.repository"})
//@EnableTransactionManagement
@PropertySource("classpath:persistence_mysql.properties")
@EnableAutoConfiguration
@EntityScan("com.music.tagger.persistence.entity")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))*/
public class JpaPersistenceConfig {
/*
    private final Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(requireNonNull(environment.getProperty("jdbc.driver_class")));
        dataSource.setUrl(requireNonNull(environment.getProperty("jdbc.url")));
        dataSource.setUsername(requireNonNull(environment.getProperty("jdbc.username")));
        dataSource.setPassword(requireNonNull(environment.getProperty("jdbc.password")));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan("com.music.tagger.persistence.entity");
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setJpaProperties(additionalProperties());

        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    private Properties additionalProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", requireNonNull(environment.getProperty("hibernate.hbm2ddl.auto")));
        hibernateProperties.setProperty("hibernate.dialect", requireNonNull(environment.getProperty("hibernate.dialect")));
        hibernateProperties.setProperty("hibernate.show_sql", requireNonNull(environment.getProperty("hibernate.show_sql")));

        return hibernateProperties;
    }
*/
}
