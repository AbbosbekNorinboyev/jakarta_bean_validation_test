package com.example.lesson9.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "username bo'sh bo'lmasligi kerak")
//    @NotBlank
    private String username;
    @NotBlank(message = "Email null bo'lmasligi kerak")
    @Email(message = "Email Email bo'lishi kerak", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
    @NotBlank
    private String role;
    @ValidAboutMe(message = "O'zingiz haqingizdagi xabar 1 ta va undan ortiq bo'lishi kerak")
    private String about;
    //    @Positive
    @Min(value = 20, message = "Yoshi {value} dan kichik bo'lmasligi kerak")
    private Integer age;

}
