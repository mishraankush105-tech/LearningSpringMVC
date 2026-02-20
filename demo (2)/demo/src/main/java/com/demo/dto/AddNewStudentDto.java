package com.demo.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.stereotype.Service;

//@Getter
//@Setter


public class AddNewStudentDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must be atleast 2 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invaild email formate")
    private String email;

    @NotNull(message = "Number is requied")
    @Min(value = 10, message = "Number must be atlest 10")
    @Max(value = 11, message = "Number must be max 11")
    private String number;

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

    public AddNewStudentDto() {
    }

    public AddNewStudentDto(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }
}
