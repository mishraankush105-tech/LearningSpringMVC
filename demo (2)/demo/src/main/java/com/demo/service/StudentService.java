package com.demo.service;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.StudentDto;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

     List<StudentDto> getStudent();
     StudentDto getStudentById( Long myid);
      StudentDto createNewStudent(AddNewStudentDto addNewStudnetDto);

    void deleteStudentById(Long id);

    @Nullable StudentDto updateStudentById(Long id, AddNewStudentDto addNewStudentDto);
}
