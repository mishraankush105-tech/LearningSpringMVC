package com.demo.controller;

import com.demo.dto.StudentDto;
import com.demo.reposistory.StudentReposistory;
import com.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

//    private final StudentReposistory studentReposistory;
    private final StudentService studentService;

    @GetMapping
   public ResponseEntity<List<StudentDto>> getAllstudent(){
        return ResponseEntity.ok(studentService.getStudent());
   }


}
