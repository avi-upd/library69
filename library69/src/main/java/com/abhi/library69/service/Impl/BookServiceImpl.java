package com.abhi.library69.service.Impl;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import com.abhi.library69.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {


    Map<String,Book> bookMap = new HashMap<>();

    public void addBook(Book book){

        Integer Id  = new Random().nextInt(1,3);
        book.setId(String.valueOf(Id));

        bookMap.put(book.getId(),book);
    }

    public Set<Book> getAllBooks(){
        return new HashSet<>(bookMap.values());
    }

    public Book getById(String Id){

        if(bookMap.containsKey(Id)){
            return bookMap.get(Id);
        }
        return null;
    }

    public Set<Book> getByGenre(Genre genre){
        return bookMap.values().stream()
                                .filter((book)->book.getGenre()==genre)
                                .collect(Collectors.toSet());
    }

    public Set<Book> getByAuthor(String author){

        return bookMap.values().stream()
                .filter((book)->book.getAuthor().equals(author))
                .collect(Collectors.toSet());
    }

    public void deleteBook(String bookId){
        bookMap.remove(bookId);
    }

    public Book updateBook(String Id,Book book){
        if(bookMap.containsKey(Id)){
            bookMap.put(Id,book);
            return bookMap.get(Id);
        }
        return null;
    }

    public void addReview(String bookId, Review review){

        Integer reviewId  = new Random().nextInt(1,3);
        review.setId(String.valueOf(reviewId));
        Book book = bookMap.get(bookId);
        book.getReviewList().add(review);

    }


}
