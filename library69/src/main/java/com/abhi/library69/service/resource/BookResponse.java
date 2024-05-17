package com.abhi.library69.service.resource;

import com.abhi.library69.domain.Genre;
import com.abhi.library69.domain.Review;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private Integer id;
    private String title;
    private String author;
    private Double rating;
    private List<Review> reviewList;

}
