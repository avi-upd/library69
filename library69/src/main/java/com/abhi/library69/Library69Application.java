package com.abhi.library69;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Library69Application implements CommandLineRunner{

	public static void main(String[] args)  {

		SpringApplication.run(Library69Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;


	@Override
	public void run(String... args) throws Exception {

//		Book book = new Book();
//		book.setTitle("Harry Potter");
//		book.setAuthor("JK Rowling");
//		book.setCost(1000.0);
//		book.setGenre(Genre.FANTASY);
//		book.setYear(2000);
//		book.setRating(5.0);
//
//		bookRepository.save(book);
////		bookRepository.deleteById(2);
//
//		List<Book> bookList = bookRepository.findAll();
//
//		bookList = bookRepository.findByAuthor("JK Rowling");
//
//		for(Book b : bookList){
//			System.out.println(b);
//		}


	}
}
