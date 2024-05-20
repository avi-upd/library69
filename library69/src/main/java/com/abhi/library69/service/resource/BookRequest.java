package com.abhi.library69.service.resource;


import com.abhi.library69.domain.Book;
import com.abhi.library69.domain.Genre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    private Genre genre;
    @Min(value = 0,message = "Cost cannot be less than 0")
    private Double cost;
    @Min(value = 1000,message = "Year cannot be less the 1000")
    private Integer year;


    public Book getBook(){


        return Book.builder()
                .title(this.title).cost(this.cost)
                .author(this.author).year(this.year)
                .rating(0.0).genre(this.genre)
                .build();
    }

}
