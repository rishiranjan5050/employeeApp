package com.employee.employee.service;

import com.employee.employee.model.Employee;
import com.employee.employee.persistance.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRespository repository;

    @Override
    public List<Employee> all() {
        List<Employee> employes = new ArrayList<>();
        repository.findAll().forEach(employes::add);
        return employes;
    }

    @Override
    public Employee addEmployee(Employee emp) {
       return  repository.save(emp);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> emp =  repository.findById(id);
        return emp.get();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> findEMployeeByPan(String pan) {
        return repository.findEmployeeByPan(pan);

    }
}
