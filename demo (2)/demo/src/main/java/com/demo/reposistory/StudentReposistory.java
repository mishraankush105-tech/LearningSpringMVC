package com.demo.reposistory;

import com.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReposistory extends JpaRepository<Student,Long> {

}
