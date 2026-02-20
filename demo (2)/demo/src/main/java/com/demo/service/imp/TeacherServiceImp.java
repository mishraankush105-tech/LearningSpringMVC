package com.demo.service.imp;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.AddNewTeacherDto;
import com.demo.dto.StudentDto;
import com.demo.dto.TeacherDto;

import com.demo.entity.Teacher;
import com.demo.reposistory.TeacherReposistory;
import com.demo.service.TeacherService;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherServiceImp implements TeacherService {

    public final TeacherReposistory teacherReposistory;
    public final ModelMapper modelMapper;


    @Override
    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = teacherReposistory.findAll();
        return teachers.stream().map(teacher -> modelMapper.map(teachers,TeacherDto.class)).toList();
    }

    @Override
    public @Nullable TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherReposistory.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher dose not found"));
        return modelMapper.map(teacher,TeacherDto.class);
    }

    @Override
    public @Nullable TeacherDto createNewTeacher(AddNewTeacherDto addNewTeacherDto) {
        Teacher newTeacher = modelMapper.map(addNewTeacherDto,Teacher.class);
        Teacher teacher = teacherReposistory.save(newTeacher);
        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public void deleteTeacherById(Long id) {
        if(!teacherReposistory.existsById(id)){
            throw new IllegalArgumentException("Id not found: "+id);
        }
        teacherReposistory.deleteById(id);
    }
}
