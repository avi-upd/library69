package com.abhi.library69.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Entity
@Builder
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private String title;
    private String author;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private Double rating;
    private Double cost;
    private Integer year;

    //Book - Review
    //One book can have many reviews -> OneToMany

//    @OneToMany
//    private List<Review> reviewList;

//    @OneToMany(mappedBy = "comment")
//    private List<Review> reviewList;

    @OneToMany(mappedBy ="book",fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JsonIgnoreProperties("book")
    private List<Review> reviewList;


}
