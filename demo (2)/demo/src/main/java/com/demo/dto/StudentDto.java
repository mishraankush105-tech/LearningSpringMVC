package com.demo.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
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
}
