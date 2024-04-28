package com.abhi.library69.service;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface BookService {

    public void addBook(Book book);

    public Set<Book> getAllBooks();

    public Book getById(String Id);

    public Set<Book> getByGenre(Genre genre);

    public Set<Book> getByAuthor(String author);

    public void deleteBook(String bookId);

    public Book updateBook(String Id,Book book);

    public void addReview(String bookId, Review review);

}
