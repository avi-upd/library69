package com.abhi.library69.controller;


import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import com.abhi.library69.domain.User;
import com.abhi.library69.service.BookService;
import com.abhi.library69.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    BookService bookService;


    @GetMapping("/book")
    public ResponseEntity<Set<Book>> getAllBooks(){

        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);

    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String bookId){

        return new ResponseEntity<>(bookService.getById(bookId),HttpStatus.OK);
    }

    @GetMapping("/book/search")
    public ResponseEntity<Set<Book>> getBookByGenre(@RequestParam("genre") Genre genre){

        return new ResponseEntity<>(bookService.getByGenre(genre),HttpStatus.OK);
    }


    @PostMapping("/{bookId}/review")
    public ResponseEntity<Book> addReview(@PathVariable("bookId") String bookId, @RequestBody Review review){
        bookService.addReview(bookId,review);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){
//        return new ResponseEntity<>(userService);
//    }
}




/***
 *
 * Two ways to read from GET API
 * 1. Query Param
 *      ones which are after the ? symbol in the URL and has key as variable name and value as value
 *      eg-> /book?bookId=1
 *      @RequestParam-> Should be used in the parameters of method
 *                      to map the query param values of URL to Java variables
 *
 * 2. Path Param
 *      ones which are part of the URL itself
 *      eg-> /book/1
 *      where 1 is the ID of the Book
 *
 *      @PathVariable-> Should be used in the parameters of method
 *  *                   to map the path params values of URL to Java variables
 *
 *
 * */
