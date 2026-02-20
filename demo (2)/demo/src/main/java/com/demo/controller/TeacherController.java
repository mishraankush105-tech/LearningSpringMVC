package com.demo.controller;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.AddNewTeacherDto;
import com.demo.dto.StudentDto;
import com.demo.dto.TeacherDto;
import com.demo.service.TeacherService;
import com.demo.service.imp.TeacherServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeacher(){
        return ResponseEntity.of(Optional.ofNullable(teacherService.getAllTeacher()));
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createNewTeacher(@RequestBody AddNewTeacherDto addNewTeacherDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.createNewTeacher(addNewTeacherDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTeacherByID(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return ResponseEntity.noContent().build();
    }


}
