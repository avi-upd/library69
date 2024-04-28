package com.abhi.library69.controller;

import com.abhi.library69.domain.Book;
import com.abhi.library69.service.BookService;
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
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book){

        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("bookId") String Id,@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(Id,book),HttpStatus.OK);
    }

    @DeleteMapping("/admin/book")
    public ResponseEntity<Book> deleteBook(@RequestParam("Id") String id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/admin/user")
//    public ResponseEntity<User> createUser(RequestBody User user){
//
//    }

}
