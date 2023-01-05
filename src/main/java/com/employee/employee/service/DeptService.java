package com.employee.employee.service;

import com.employee.employee.model.Department;
import com.employee.employee.model.Employee;

import java.util.List;

public interface DeptService {

    // Save operation
    Department saveDepartment(Department department);

    // Read operation
    List<Department> fetchDepartmentList();

    // Update operation
    Department updateDepartment(Department department,
                                Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);

    Department getDepartmentById(Long id);
    List<Department> all();
}
