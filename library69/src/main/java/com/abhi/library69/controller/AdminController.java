package com.abhi.library69.controller;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.User;
import com.abhi.library69.repository.BookRepository;
import com.abhi.library69.service.BookService;
import com.abhi.library69.service.UserService;
import com.abhi.library69.service.resource.BookRequest;
import com.abhi.library69.service.resource.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;


    @PostMapping("/admin/book")
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookRequest bookRequest){

        bookService.addBook(bookRequest.getBook());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("bookId") Integer Id,@RequestBody @Valid BookRequest bookRequest){

        return new ResponseEntity<>(bookService.updateBook(Id,bookRequest.getBook()),HttpStatus.OK);
    }

    @DeleteMapping("/admin/book")
    public ResponseEntity<Book> deleteBook(@RequestParam("Id") Integer id){

        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    UserService userService;


    @PostMapping("/admin/user")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest userRequest){

        userService.addUser(userRequest.getUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("admin/user")
    public ResponseEntity<User> deleteUser(@RequestParam("id") Integer id){

        userService.deleteUser(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("admin/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id,@RequestBody @Valid UserRequest userRequest){
        userService.updateUser(id,userRequest.getUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }









//    @PostMapping("/admin/user")
//    public ResponseEntity<User> createUser(RequestBody User user){
//
//    }

}
