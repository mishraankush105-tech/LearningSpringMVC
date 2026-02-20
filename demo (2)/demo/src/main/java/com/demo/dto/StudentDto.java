package com.demo.dto;

import jakarta.validation.constraints.*;
import lombok.*;

public class StudentDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be atleast 2 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Number is requied")
    @Min(value = 10, message = "Number must be atlest 10")
    @Max(value = 11, message = "Number must be max 11")
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public StudentDto(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public StudentDto() {
    }
}
