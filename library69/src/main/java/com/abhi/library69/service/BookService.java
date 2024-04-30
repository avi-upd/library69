package com.abhi.library69.service;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface BookService {

    public void addBook(Book book);

    public List<Book> getAllBooks();

    public Book getById(Integer Id);

    public List<Book> getByGenre(Genre genre);

    public List<Book> getByAuthor(String author);

    public void deleteBook(Integer bookId);

    public Book updateBook(Integer Id,Book book);

    public void addReview(Integer bookId, Review review);

}
