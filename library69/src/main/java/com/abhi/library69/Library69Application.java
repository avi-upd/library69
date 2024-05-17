package com.abhi.library69;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import com.abhi.library69.repository.BookRepository;
import com.abhi.library69.service.impl.BookCascadeSampleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Library69Application implements CommandLineRunner{

	public static void main(String[] args)  {

		SpringApplication.run(Library69Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCascadeSampleImpl bookCascadeSample;

	@Autowired
	RedisTemplate<String,Object> redisTemplate;

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setAuthor("JK Rowling");
		book.setCost(1000.0);
		book.setGenre(Genre.FANTASY);
		book.setYear(2000);
		book.setRating(5.0);

		redisTemplate.opsForValue().set("myJavaKey","myJavaValue");
		System.out.println(redisTemplate.opsForValue().get("myJavaKey"));

		redisTemplate.opsForList().rightPush("myListKey",1);
		redisTemplate.opsForList().rightPush("myListKey",2);
		redisTemplate.opsForList().rightPush("myListKey",3);
		redisTemplate.opsForList().rightPush("myListKey",4);
		redisTemplate.opsForList().rightPush("myListKey",5);

		System.out.println(redisTemplate.opsForList().leftPop("myListKey"));
		System.out.println(redisTemplate.opsForList().rightPop("myListKey"));

		redisTemplate.opsForHash().put("book",book.getTitle(),book);





	}
//			Book book = new Book();
//		book.setTitle("Harry Potter");
//		book.setAuthor("JK Rowling");
//		book.setCost(1000.0);
//		book.setGenre(Genre.FANTASY);
//		book.setYear(2000);
//		book.setRating(5.0);

//		Book book=new Book();
//		book.setTitle("testCascade");
//		book.setAuthor("JK Rowling");
//		book.setGenre(Genre.FANTASY);
//		book.setRating(5.0);
//		book.setCost(500.0);
//		book.setYear(2000);
//		List<Review> reviews=new ArrayList<>();
//		reviews.add(new Review());

//		bookRepository.save(book);

//		List<Book> books = bookRepository.findByTitleLike("testCascade");
//
//		if(!CollectionUtils.isEmpty(books)){
//
//			Book b = books.get(0);
//
//		}


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
