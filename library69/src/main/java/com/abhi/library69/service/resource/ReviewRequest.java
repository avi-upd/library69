package com.abhi.library69.service.resource;

import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Review;
import com.abhi.library69.repository.BookRepository;
import com.abhi.library69.repository.ReviewRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @NotBlank(message = "Comment cannot be empty")
    private String comment;
    @Min(value = 1,message = "rating cannot be less than 1")
    @Max(value = 5,message = "rating cannot be more than 5")
    private Double rating;
    @Min(value = 1,message = "Min Id of book is 1")
    private Integer bookId;

    @Autowired
    BookRepository bookRepository;

    public Review getReview(){

//        Optional<Book> optionalBook = bookRepository.findById(this.bookId);
//        if(optionalBook.isEmpty()){
//            throw new IllegalArgumentException("Book Id does not exist");
//        }
        return Review.builder().comment(this.comment)
                .rating(this.rating).book(Book.builder().id(this.bookId).build()).build();
    }
}
