package com.demo.service.imp;

import com.demo.dto.AddNewStudentDto;
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

    @Override
    public StudentDto getStudentById(Long myid) {
        Student student = studentReposistory.findById(myid)
                .orElseThrow(() -> new RuntimeException("Student not found id"+myid));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddNewStudentDto addNewStudnetDto) {
        Student newStudent = modelMapper.map(addNewStudnetDto, Student.class);
        Student student = studentReposistory.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }
}
