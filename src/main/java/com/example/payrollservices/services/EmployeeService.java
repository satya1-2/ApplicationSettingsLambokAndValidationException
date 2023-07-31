package com.example.payrollservices.services;

import com.example.payrollservices.dto.EmployeeDTO;
import com.example.payrollservices.exception.EmpCustomException;
import com.example.payrollservices.model.Employee;
import com.example.payrollservices.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
public class EmployeeService implements EmployeesService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsByEmail(employeeDTO.getEmail())) {
            throw new EmpCustomException("Email address (Email) already exists in Database: " + employeeDTO.getEmail());
        }
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepo.save(employeeData);
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employeeData = getEmployeeById(id);
        if (employeeData == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }

        // Check if the updated email address (Email) already exists for another employee
        String newEmail = employeeDTO.getEmail();
        if (!newEmail.equals(employeeData.getEmail()) && employeeRepo.existsByEmail(newEmail)) {
            throw new EmpCustomException("Email address (Gmail) already exists in database: " + newEmail);
        }

        employeeData.updateEmployee(employeeDTO);
        return employeeRepo.save(employeeData);
    }


    public void deleteEmployee(int id) {
        Employee employeeData = getEmployeeById(id);
        if (employeeData == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }

        employeeRepo.deleteById(id);
    }

    public void deleteAllEmployee() {

        employeeRepo.deleteAll();
    }

    public Employee getEmployeeById(int id) {

        return employeeRepo.findById(id).orElseThrow(() -> new EmpCustomException("employee with id: " + id + "not present"));
    }

    public List<Employee> getAllEmployee() {

        return employeeRepo.findAll();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        log.info(department);
        return employeeRepo.findEmployeeByDepartment(department);
    }

}