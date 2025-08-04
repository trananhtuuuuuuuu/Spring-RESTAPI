package com.project.to.learn.projectToLearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.to.learn.projectToLearn.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
}
