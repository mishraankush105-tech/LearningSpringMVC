package com.demo.service;

import com.demo.dto.AddNewStudentDto;
import com.demo.dto.AddNewTeacherDto;
import com.demo.dto.StudentDto;
import com.demo.dto.TeacherDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> getAllTeacher();

    @Nullable TeacherDto getTeacherById(Long id);

    @Nullable TeacherDto createNewTeacher(AddNewTeacherDto addNewTeacherDto);

    void deleteTeacherById(Long id);
}
