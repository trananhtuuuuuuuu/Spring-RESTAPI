package com.project.to.learn.projectToLearn.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.to.learn.projectToLearn.domain.Student;
import com.project.to.learn.projectToLearn.exception.StudentNotFound;
import com.project.to.learn.projectToLearn.service.student.StudentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@AllArgsConstructor
public class StudentController {
  private final StudentService studentService;

  @PostMapping("/students")
  public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
    Student resStudent = this.studentService.saveStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(resStudent);
  }


  @GetMapping("/students")
  public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = this.studentService.getAllStudent();
    return ResponseEntity.ok().body(students);
  }


  @GetMapping("/students/{studentId}")
  public ResponseEntity<Student> getOneStudentById(@PathVariable long studentId) throws StudentNotFound {
    if(studentId <= 0 || studentId > this.studentService.getAllStudent().size()){
      throw new StudentNotFound("Student Not Found");
    }
    Student student = this.studentService.getStudentById(studentId);
    return ResponseEntity.ok(student);
  }


  @PutMapping("/students/{studentId}")
  public ResponseEntity<Student> updateStudentById(@PathVariable long studentId, 
  @RequestBody Student student) {
      //TODO: process PUT request
    Student resStudent = this.studentService.updateStudent(studentId, student);
    return ResponseEntity.ok(resStudent);
  }


  @DeleteMapping("/students/{studentId}")
  public ResponseEntity<String> deleteStudentById(@PathVariable long studentId){
    this.studentService.deleteStudentById(studentId);
    return ResponseEntity.ok("Successfule delete");
  }
  
  


}
