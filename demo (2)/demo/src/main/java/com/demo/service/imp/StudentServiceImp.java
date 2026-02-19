package com.demo.service.imp;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.StudentDto;
import com.demo.entity.Student;
import com.demo.reposistory.StudentReposistory;
import com.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
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

    @Override
    public void deleteStudentById(Long id) {
        if(!studentReposistory.existsById(id)){
            throw new IllegalArgumentException("Studnet not exist by id:"+ id);
        }
        studentReposistory.deleteById(id);
    }

    @Override
    public @Nullable StudentDto updateStudentById(Long id, AddNewStudentDto addNewStudentDto) {
        Student student = studentReposistory.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found by id:"+id));
        modelMapper.map(addNewStudentDto, student);
               student =  studentReposistory.save(student);
               return modelMapper.map(student,StudentDto.class);
    }


}
