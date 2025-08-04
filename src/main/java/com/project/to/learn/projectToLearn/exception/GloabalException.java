package com.project.to.learn.projectToLearn.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.to.learn.projectToLearn.domain.ResponseServer;

@RestControllerAdvice
public class GloabalException {
  @ExceptionHandler(value = IdInvalidException.class)
  public ResponseEntity<ResponseServer<Object>> handleIdException(IdInvalidException idInvalidException){
    ResponseServer<Object> res = new ResponseServer<Object>();
    res.setStatusCode(HttpStatus.BAD_REQUEST.value());
    res.setError(idInvalidException.getMessage());
    res.setMessage("Id Invalid");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
  }

  @ExceptionHandler(value = StudentNotFound.class)
  public ResponseEntity<ResponseServer<Object>> handleStudentNotFound(StudentNotFound studentNotFound){
    ResponseServer<Object> res = new ResponseServer<Object>();
    res.setStatusCode(HttpStatus.NOT_FOUND.value());
    res.setError(studentNotFound.getMessage());
    res.setMessage("Student Not Found");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
  }
}
