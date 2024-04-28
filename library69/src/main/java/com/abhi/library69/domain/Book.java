package com.abhi.library69.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id; //not a part of Request

    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Title cannot be blank")
    private String author;
    private Genre genre;
    @Min(value = 0,message = "Rating cannot be less than 0")
    @Max(value = 5,message = "Rating cannot be more than 5")
    private Double rating; // not a part of Request

    private List<Review> reviewList; // not a part of request
    @Min(value = 0,message = "Cost cannot be less than 0")
    private Double cost;
    @Min(value = 1000,message = "Year cannot be less the 1000")
    private Integer year;


    @Override
    public int hashCode() {
        return Integer.valueOf(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }



    // getters and setters here

}
