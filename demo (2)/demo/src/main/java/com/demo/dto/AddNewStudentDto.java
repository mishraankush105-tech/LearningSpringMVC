package com.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


}
