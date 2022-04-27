//package com.example.twotables.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MyDataSourceAutoConfiguration {
//
//    @Bean
//    @ConfigurationProperties(prefix = "app.datasource")
//    public DataSource dataSource() {
//        return new HikariDataSource();
//    }
//
//}
