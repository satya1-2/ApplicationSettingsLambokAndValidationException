package com.example.payrollservices.services;

import com.example.payrollservices.dto.EmployeeDTO;
import com.example.payrollservices.model.Employee;

import java.util.List;

public interface EmployeesService {
    Employee addEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(int id, EmployeeDTO employeeDTO);

    void deleteEmployee(int id);

    void deleteAllEmployee();

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

     List<Employee>getEmployeesByDepartment(String department);


}
