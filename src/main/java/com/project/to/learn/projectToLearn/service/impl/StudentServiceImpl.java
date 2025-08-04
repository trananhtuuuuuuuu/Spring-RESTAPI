package com.project.to.learn.projectToLearn.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.to.learn.projectToLearn.domain.Student;
import com.project.to.learn.projectToLearn.repository.StudentRepository;
import com.project.to.learn.projectToLearn.service.student.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository){
    this.studentRepository = studentRepository;
  }

  @Override
  public void deleteStudentById(long id) {
    // exception id not found, or id so big, or id not int

    this.studentRepository.deleteById(id);
    
  }


  @Override
  public List<Student> getAllStudent() {
    // not need exception handler
    return this.studentRepository.findAll();
  }

  @Override
  public Student getStudentById(long id) {
    // exception id not found, or id so big, or id not int
  
    Optional<Student> student = this.studentRepository.findById(id);
    if(student.isEmpty()){
      return null;
    }
    Student resStudent = new Student(student.get().getFirstName(),
    student.get().getLastName(), 
    student.get().getEmail(), 
    student.get().getGpa());
    return resStudent;
  }

  @Override
  public Student saveStudent(Student student) {
    // exception student empty or gpa not double datatype
    return this.studentRepository.save(student);
  }

  @Override
  public Student updateStudent(long id, 
  Student student) {
    // exception id not found, or id so big, or id not int
    Optional<Student> studentFromDb = this.studentRepository.findById(id);
    if(studentFromDb.isEmpty()){
      return null;
    }
    studentFromDb.get().setFirstName(student.getFirstName());
    studentFromDb.get().setLastName(student.getLastName());
    //studentFromDb.get().setId(student.getId());
    studentFromDb.get().setEmail(student.getEmail());
    studentFromDb.get().setGpa(student.getGpa());
    return student;
  }
  
}
