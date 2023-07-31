package com.example.payrollservices.repo;

import com.example.payrollservices.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    // Custom query to check if an employee with the given email (gmail) already exists
    boolean existsByEmail(String gmail);

    @Query(value = "select  *  from employee_payroll,employee_department where  employee_id=id and department=:department",nativeQuery = true)
    List<Employee>findEmployeeByDepartment(String department);
}
