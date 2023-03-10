package com.employee.employee.service;

import com.employee.employee.model.Department;
import com.employee.employee.persistance.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        return repository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Department> all() {
        List<Department> deptlist = new ArrayList<>();
         repository.findAll().forEach(deptlist::add);
         return deptlist;
    }
}
