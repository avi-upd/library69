package com.abhi.library69.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

@Configuration
public class DBConfiguration {

//    @Value("${mysql-uri}")
//    String uri;
//
//    @Value("${mysql-username}")
//    String username;
//
//    @Value("${mysql-password}")
//    String password;


//    @Bean("Database")
//    public Connection mysqlConnection(){
//        System.out.println("I am getting configured");
//        System.out.println("Host : "+uri+" Username : "+username+" Password : "+password);
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(uri,username,password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }

//    @Bean("oracleDatabaseConnection")
//    public Connection oracleConnection(){
//        System.out.println("I am getting configured");
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","jbdl69dl","Abhishek@123");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }
}
