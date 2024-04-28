package com.abhi.library69.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private String id; //not a part of request

    private String comment;

    private String reviewer;

    private Double rating; // not a part of request

    private String bookId;
}
