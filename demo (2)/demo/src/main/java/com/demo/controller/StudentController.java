package com.demo.controller;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.StudentDto;
import com.demo.entity.Student;
import com.demo.reposistory.StudentReposistory;
import com.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

//    private final StudentReposistory studentReposistory;
    private final StudentService studentService;

    @GetMapping("/students")
   public ResponseEntity<List<StudentDto>> getAllstudent(){
        return ResponseEntity.ok(studentService.getStudent());
   }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> creatNewStudent(@RequestBody AddNewStudentDto addNewStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addNewStudentDto));
    }



}
