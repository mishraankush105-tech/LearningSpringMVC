package com.demo.reposistory;

import com.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherReposistory extends JpaRepository<Teacher,Long> {
}
