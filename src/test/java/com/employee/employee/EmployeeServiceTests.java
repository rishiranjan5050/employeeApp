package com.employee.employee;

import com.employee.employee.model.Employee;
import com.employee.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes ={EmployeeApplication.class,H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class EmployeeServiceTests {
    @Autowired
    EmployeeService service;

    @Test
    void addEmployeeTest(){
        Employee emp = new Employee(1L,"Samba","25/12/1989","aqr101","delhi-001",501);
        service.addEmployee(emp);
        Assertions.assertEquals(service.getEmployee(1L).getName(),"Samba");
    }
}
