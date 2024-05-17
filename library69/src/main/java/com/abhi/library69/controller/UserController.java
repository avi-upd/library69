package com.abhi.library69.controller;


import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import com.abhi.library69.domain.User;
import com.abhi.library69.service.BookService;
import com.abhi.library69.service.resource.BookResponse;
import com.abhi.library69.service.resource.ReviewRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    BookService bookService;


    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks(){


        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);

    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer bookId){

        return new ResponseEntity<>(bookService.getById(bookId),HttpStatus.OK);
    }

    @GetMapping("/book/search")
    public ResponseEntity<List<Book>> getBookByGenre(@RequestParam("genre") Genre genre){

        return new ResponseEntity<>(bookService.getByGenre(genre),HttpStatus.OK);
    }


//    @PostMapping("/{bookId}/review")
//    public ResponseEntity<Book> addReview(@PathVariable("bookId") Integer bookId, @RequestBody @Valid ReviewRequest reviewRequest){
//
//        reviewRequest.setBookId(bookId);
//        bookService.addReview(bookId,reviewRequest.getReview());
//        return new ResponseEntity<>(HttpStatus.CREATED);
//
//    }
//
//    @Autowired
//    UserService userService;
//
//    @GetMapping("/user")
//    public ResponseEntity<List<User>> getAllUsers(){
//
//        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
//    }
//
//    @GetMapping("/user/{username}")
//    public ResponseEntity<User> getByUsername(@PathVariable("username") String username){
//
//        return new ResponseEntity<>(userService.getByUsername(username),HttpStatus.OK);
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId){
//
//        return new ResponseEntity<>(userService.getById(userId),HttpStatus.OK);
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
