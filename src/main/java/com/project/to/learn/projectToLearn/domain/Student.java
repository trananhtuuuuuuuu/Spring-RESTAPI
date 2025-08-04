package com.project.to.learn.projectToLearn.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  @Column(name="email_name")
  private String email;

  @Column(name="gpa")
  private double gpa;
  public Student(){

  }

  public Student(String firstName, String lastName, String email, double gpa){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gpa = gpa;
  }
}
