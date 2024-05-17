package com.abhi.library69.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
//@Table(name = "users")
//@Entity
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
//    @Enumerated(EnumType.STRING)
    //private Role role;
    private String email;
    private String phoneNumber;
}
