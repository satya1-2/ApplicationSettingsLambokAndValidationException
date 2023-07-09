package com.example.payrollservices.services;

import com.example.payrollservices.dto.EmployeeDTO;
import com.example.payrollservices.exception.EmpCustomException;
import com.example.payrollservices.model.Employee;
import com.example.payrollservices.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeesService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepo.save(employeeData);


    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employeeData = employeeRepo.findById(id).orElse(null);
        if (employeeData == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        employeeData.setName(employeeDTO.getName());
        employeeData.setAddress(employeeDTO.getAddress());
        return employeeRepo.save(employeeData);
    }

    public void deleteEmployee(int id) {
        Employee employeeData = employeeRepo.findById(id).orElse(null);
        if (employeeData == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }

        employeeRepo.delete(employeeData);
    }

    public void deleteAllEmployee() {

        employeeRepo.deleteAll();
    }

    public Employee getEmployeeById(int id) {

        return employeeRepo.findById(id).orElseThrow(()->new EmpCustomException("employee with id: "+id+"not present"));
    }


    public List<Employee> getAllEmployee() {

        return employeeRepo.findAll();
    }

}
