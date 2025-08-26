package com.codewithvihanga.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserDto {
    @NotBlank(message = "Name is required") //ensures that name is not an empty or white space
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message= "Password is required")
    @Size(min = 6, max=25, message = "Password must be between 6 to 25 characters long.")
    private String password;
}
