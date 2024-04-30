package com.abhi.library69.service.impl;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import com.abhi.library69.repository.BookRepository;
import com.abhi.library69.service.BookService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    public void addBook(Book book){

        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){

        return bookRepository.findAll();
    }

    public Book getById(Integer id){

        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getByGenre(Genre genre){

        return bookRepository.findByGenre(genre);
    }

    public List<Book> getByAuthor(String author){

        return bookRepository.findByAuthor(author);
    }

    public void deleteBook(Integer id){

        bookRepository.deleteById(id);
    }

    public Book updateBook(Integer id,Book book){

        Optional<Book> originalBook = bookRepository.findById(id); //this logic is not updating the existing book , rather creates a new book
        if(originalBook.isPresent()){
            bookRepository.save(book);
        }
        return book;
    }

    @Override
    public void addReview(Integer bookId, Review review) {
        //
    }




}
