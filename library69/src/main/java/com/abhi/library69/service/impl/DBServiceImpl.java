package com.abhi.library69.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DBServiceImpl {


//    @Autowired
//    private Connection mysqlConnection;
//
//    private PreparedStatement addBookStatement = null;
//
//
//    @PostConstruct
//    public void init(){
//        log.info("MySql connection is "+mysqlConnection);
//        log.info("Creating table if not exists");
//        String query="create table if not exists book(id int primary key auto_increment,title varchar(100),author varchar(100),genre varchar(10),rating double,cost double,year int)";
//        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
//            statement.execute(query);
//        }
//        catch (SQLException e){
//            throw new RuntimeException();
//        }
//
//        try {
//            addBookStatement = mysqlConnection.prepareStatement("insert into book(title,author,genre,rating,cost,year) values(?,?,?,?,?,?)");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
////    @Override
////    public Book addBook(Book book){
////        String query="insert into book(title,author,genre,rating,cost,year) values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getGenre()+"','"+book.getRating()+"','"+book.getCost()+"','"+book.getYear()+"')";
////        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
////            statement.execute(query);
////            return book;
////        }
////        catch (SQLException e){
////            log.error("Error adding book to DB: {}",e.getMessage());
////        }
////        return null;
////    }
//
////    @Override
////    public Book addBook(Book book){
////        String query="insert into book(title,author,genre,rating,cost,year) values(?,?,?,?,?,?)";
////        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
////            statement.execute(query);
////            return book;
////        }
////        catch (SQLException e){
////            log.error("Error adding book to DB: {}",e.getMessage());
////        }
////        return null;
////    }
//
//    @Override
//    public Book addBook(Book book){
//        String query="insert into book(title,author,genre,rating,cost,year) values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getGenre()+"','"+book.getRating()+"','"+book.getCost()+"','"+book.getYear()+"')";
//        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
//            statement.execute(query);
//            return book;
//        }
//        catch (SQLException e){
//            log.error("Error adding book to DB: {}",e.getMessage());
//        }
//        return null;
//    }
//
//
//
//
//
//
//    @Override
//    public List<Book> getAllBooks() {
//        String query = "Select * from book";
//        try(Statement statement = mysqlConnection.createStatement()){ //Try with resources Auto closes the statement if or if not something wrong happens in mysql or connection etc. (because it extends autocloseable)
//            statement.execute(query);
//            ResultSet resultSet = statement.executeQuery(query);
//            List<Book> bookList = new ArrayList<>();
//            while(resultSet.next()){
//                Book book = new Book();
//                book.setId(resultSet.getString("id"));
//                book.setId(resultSet.getString("id"));
//            }
//
//
//
//        }
//        catch (SQLException e){
//            log.error("Error adding book to DB: {}",e.getMessage());
//        }
//
//
//        return List.of();
//    }
}
