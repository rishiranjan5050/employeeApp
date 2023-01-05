package com.employee.employee.service;

import com.employee.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> all();
     Employee addEmployee(Employee emp);
     Employee getEmployee(Long id);
     void deleteEmployeeById(Long id);
     List<Employee> findEMployeeByPan(String pan);
}
