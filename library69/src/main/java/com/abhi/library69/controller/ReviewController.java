package com.abhi.library69.controller;

import com.abhi.library69.domain.Review;
import com.abhi.library69.service.ReviewService;
import com.abhi.library69.service.resource.ReviewRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody @Valid ReviewRequest reviewRequest){

        reviewService.addReview(reviewRequest.getReview());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
