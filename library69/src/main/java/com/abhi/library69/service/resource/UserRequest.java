package com.abhi.library69.service.resource;

import com.abhi.library69.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;

    public User getUser(){

        return User.builder()
                .email(this.email)
                .password(this.password)
                .username(this.username)
                .phoneNumber(this.phoneNumber)
                .build();

    }


}
