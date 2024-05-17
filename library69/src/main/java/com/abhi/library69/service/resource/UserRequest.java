//package com.abhi.library69.service.resource;
//
//import com.abhi.library69.domain.Role;
//import com.abhi.library69.domain.User;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class UserRequest {
//
//    @Size(min = 3,max = 15,message = "3 <= Username_Size <= 15")
//    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "Bhag bhosdike")
//    private String username;
//
//    @Size(min = 8,max = 25, message = "8 <= Password_Size <= 25")
//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}$")
//    private String password;
//
//    @Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$",
//             message = " The email couldn't start or finish with a dot. " +
//                     "The email shouldn't contain spaces into the string. " +
//                     "The email shouldn't contain special chars (<:, *,ecc). " +
//                     "The email could contain dots in the middle of mail address before the @. " +
//                     "The email could contain a double domain ( '.de.org' or similar rarity)")
//    private String email;
//
//    private String phoneNumber;
//
//    public User getUser(){
//
//        return User.builder().email(this.email).password(this.password)
//                .username(this.username).phoneNumber(this.phoneNumber).role(Role.NONADMIN).build();
//
//    }
//
//
//}
