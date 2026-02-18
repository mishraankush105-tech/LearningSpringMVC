package com.demo.service;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StudentService {

     List<StudentDto> getStudent();
     StudentDto getStudentById( Long myid);
      StudentDto createNewStudent(AddNewStudentDto addNewStudnetDto);
}
