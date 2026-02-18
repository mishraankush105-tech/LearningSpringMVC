package com.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddNewStudentDto {
    @NotBlank(message = "Email is required")
    @Email(message = "Invaild email formate")
    private String email;

    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be atleast 2 characters")
    private String name;
}
