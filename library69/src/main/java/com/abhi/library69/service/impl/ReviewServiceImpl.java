package com.abhi.library69.service.impl;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Review;
import com.abhi.library69.repository.BookRepository;
import com.abhi.library69.repository.ReviewRepository;
import com.abhi.library69.service.BookService;
import com.abhi.library69.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookService bookService;

    @Override
    public void addReview(Review review) {

        Book book = bookService.getById(review.getBook().getId());

        if(book==null){
            throw new IllegalArgumentException("Book Id does not exit");
        }

        Double rating  = book.getRating();
        Integer reviewCount = book.getReviewList().size();
        rating = (rating*reviewCount + review.getRating())/(reviewCount+1);
        book.setRating(rating);
        review.setBook(book);
        reviewRepository.save(review);

    }
}
