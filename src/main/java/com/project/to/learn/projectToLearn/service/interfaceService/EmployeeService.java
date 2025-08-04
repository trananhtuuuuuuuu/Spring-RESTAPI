package com.project.to.learn.projectToLearn.service.interfaceService;

import java.util.List;

import com.project.to.learn.projectToLearn.domain.Employee;

public interface EmployeeService {

  List<Employee> getAllEmployees();

  Employee getOneEmployeeById(long id);

  Employee saveOneEmployee(Employee employee);

  Employee updateEmployee(long id, Employee employee);

  void deleteEmployeeById(long id);
  
}
