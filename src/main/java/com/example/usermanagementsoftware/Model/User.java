package com.example.usermanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name should not be empty")
    @Size(min = 5,message = "name must be more than 4 characters")
    @Pattern(regexp = "^[a-zA-Z]{5,20}$",message = "name must contain only characters")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;

    @NotEmpty(message = "username should not be empty")
    @Size(min = 5,message = "username must be more than 4 characters")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
    private String username;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email must contain an @ sign")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String password;

    @NotNull(message = "age should not be empty")
    @Digits(integer=2,fraction=0,message = "age should be digits")
    @Positive(message = "age should be positive")
    @Column(columnDefinition = "INT NOT NULL") // CHECK(age > 21)
    private int age;

    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "USER|ADMIN",message = "role must be either USER OR ADMIN")
    @Column(columnDefinition = "VARCHAR(5) NOT NULL") // CHECK(role = 'EMPLOYER' OR role = 'JOB_SEEKER')
    private String role;
}
