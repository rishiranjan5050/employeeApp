package com.employee.employee.persistance;

import com.employee.employee.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends CrudRepository<Employee,Long> {

    @Query(value="select * from Employee where pan=:pan",nativeQuery = true)
    List<Employee> findEmployeeByPan(@Param("pan") String pan);
}