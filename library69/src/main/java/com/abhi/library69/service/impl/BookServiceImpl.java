package com.abhi.library69.service.impl;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import com.abhi.library69.repository.BookRepository;
import com.abhi.library69.repository.ReviewRepository;
import com.abhi.library69.service.BookService;
import com.abhi.library69.service.resource.BookResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReviewRepository reviewRepository;


    public void addBook(Book book){

        bookRepository.save(book);
    }

//    public List<BookResponse> getAllBooks(){
//
//        List<Book> books = bookRepository.findAll();
//        List<BookResponse> bookResponses = new ArrayList<>();
//        for(Book book : books){
//
//            List<Review> reviews = reviewRepository.findByBookId(book.getId());
//            bookResponses.add(BookResponse.builder().id(book.getId()).reviewList(reviews).title(book.getTitle()).author(book.getAuthor())
//                            .rating(book.getRating()).build());
//
//        }
//        return bookResponses;
//    }


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


//    @Override
//    public void addReview(Integer bookId, Review review) {
//
//        Optional<Book> book = bookRepository.findById(bookId);
//        if(book.isPresent()){
//            Book b = book.get();
//            b.getReviews().add(review);
//        }
//    }




}
