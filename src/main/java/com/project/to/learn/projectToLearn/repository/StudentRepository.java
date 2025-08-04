package com.project.to.learn.projectToLearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.to.learn.projectToLearn.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>  {
  
}
