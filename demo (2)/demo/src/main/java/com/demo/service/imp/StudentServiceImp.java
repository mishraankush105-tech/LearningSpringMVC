package com.demo.service.imp;

import com.demo.dto.StudentDto;
import com.demo.entity.Student;
import com.demo.reposistory.StudentReposistory;
import com.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentReposistory studentReposistory;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getStudent() {
        List<Student> students = studentReposistory.findAll();
        return students.stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
    }
}
