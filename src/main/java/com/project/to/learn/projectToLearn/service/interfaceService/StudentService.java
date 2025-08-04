package com.project.to.learn.projectToLearn.service.interfaceService;

import java.util.List;

import com.project.to.learn.projectToLearn.domain.Student;


public interface StudentService {

  List<Student> getAllStudent();

  Student saveStudent(Student student);


  Student updateStudent(long id, Student student);


  Student getStudentById(long id);

  void deleteStudentById(long id);
  
  
}
