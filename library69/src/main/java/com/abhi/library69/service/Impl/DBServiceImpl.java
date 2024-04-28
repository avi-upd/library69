package com.abhi.library69.service.Impl;

import com.abhi.library69.domain.Book;
import com.abhi.library69.service.DBService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DBServiceImpl implements DBService {


    @Autowired
    Connection mysqlConnection;





    @PostConstruct
    public void init(){
        log.info("MySql connection is "+mysqlConnection);
        log.info("Creating table if not exists");
        String query="create table if not exists book(id int primary key auto_increment,title varchar(100),author varchar(100),genre varchar(10),rating double,cost double,year int)";
        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
            statement.execute(query);
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }
    @Override
    public Book addBook(Book book){
        String query="insert into book(title,author,genre,rating,cost,year) values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getGenre()+"','"+book.getRating()+"','"+book.getCost()+"','"+book.getYear()+"')";
        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
            statement.execute(query);
            return book;
        }
        catch (SQLException e){
            log.error("Error adding book to DB: {}",e.getMessage());
        }
        return null;
    }






    @Override
    public List<Book> getAllBooks() {
        String query = "Select * from book";
        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
            statement.execute(query);
            ResultSet resultSet = statement.executeQuery(query);
            List<Book> bookList = new ArrayList<>();
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getString("id"));
                book.setId(resultSet.getString("id"));
            }



        }
        catch (SQLException e){
            log.error("Error adding book to DB: {}",e.getMessage());
        }


        return List.of();
    }
}
