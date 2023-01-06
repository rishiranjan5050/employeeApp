package com.employee.employee.controller;

import com.employee.employee.exception.DeprtmentNotFoundException;
import com.employee.employee.exception.EmployeeNotFoundException;
import com.employee.employee.model.Department;
import com.employee.employee.model.Employee;
import com.employee.employee.service.DeptService;
import com.employee.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AppController {
    Logger logger = LoggerFactory.getLogger(AppController.class);
    @Autowired
    EmployeeService empService;

    @Autowired
    DeptService deptService;

    @PostMapping("/employees")
    Employee addEmployee(@RequestBody Employee emp){
        logger.info("adding Employess with body :"+emp.toString());
        return empService.addEmployee(emp);
    }

    @GetMapping("/employees")
    List<Employee> allEmployees() {
        logger.info("Fetching all employees.");
        return empService.all();
    }

    @GetMapping("/emp/pan/{pan}")
    List<Employee> getEmployeeByPan(@PathVariable String pan){
        logger.info("Fetching employee with Pan -"+pan);
        List<Employee> employees =  empService.findEMployeeByPan(pan);
        if(employees.size() < 1)
            throw new EmployeeNotFoundException();
        return employees;
    }

    @GetMapping("/employee/{id}")
    Employee getEmployee(@PathVariable Long id){
        logger.info("Get employee with Id : %d",+id);
        try {
            return empService.getEmployee(id);
        }catch(Exception ex){
            throw new EmployeeNotFoundException();
        }
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity deleteEmployee(@PathVariable Long id){
        try {
            Employee emp = empService.getEmployee(id);
            empService.deleteEmployeeById(id);
            return new ResponseEntity<>(emp.toString() + "  Deleted ....", HttpStatus.OK);
        }catch(Exception ex){
            throw new EmployeeNotFoundException();
        }
    }

    @PostMapping("/departments")
    ResponseEntity<Object> addDepartment(@RequestBody Department dpt){
        try {
            deptService.saveDepartment(dpt);
            return new ResponseEntity("Department added ", HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity("Department could not be added ",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/departments")
    List<Department> allDepartment() {
        logger.info("Fetching all employees.");
        List<Department> deptlist = deptService.all();
        if(deptlist.size()<1){ throw new DeprtmentNotFoundException();};

         return deptlist;
    }

    @GetMapping("/department/{id}")
    Department getDepartment(@PathVariable Long id){
        logger.info("Get Department with Id : %d",+id);
        try {
            return deptService.getDepartmentById(id);
        }catch(Exception ex){
            throw new DeprtmentNotFoundException();
        }
    }

    @DeleteMapping("/department/{id}")
    ResponseEntity<Object> deleteDepartment(@PathVariable Long id){
        try {
            Department dept = deptService.getDepartmentById(id);
            deptService.deleteDepartmentById(id);
            return new ResponseEntity<>(dept.toString() + "  Deleted ....", HttpStatus.OK);
        }catch(Exception ex){
            throw new DeprtmentNotFoundException();
        }
    }
}
