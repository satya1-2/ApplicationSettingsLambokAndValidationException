package com.example.payrollservices.controller;

import com.example.payrollservices.dto.EmployeeDTO;
import com.example.payrollservices.dto.ResponseDTO;
import com.example.payrollservices.model.Employee;
import com.example.payrollservices.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.debug("Adding employee: {}", employeeDTO);
        Employee employee = employeeService.addEmployee(employeeDTO);
        log.info("Employee added successfully: {}", employee);
        ResponseDTO responseDTO = new ResponseDTO("Data added Successfully", employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        log.debug("Updating employee with ID: {}", id);
        Employee employee = employeeService.updateEmployee(id, employeeDTO);
        log.info("Employee updated successfully: {}", employee);
        ResponseDTO responseDTO = new ResponseDTO("Data updated Successfully", employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
        log.debug("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        log.info("Employee deleted successfully. ID: {}", id);
        ResponseDTO responseDTO = new ResponseDTO("Data deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<ResponseDTO> deleteAllEmployee() {
        log.debug("Deleting all employees");
        employeeService.deleteAllEmployee();
        log.info("All employees deleted successfully");
        ResponseDTO responseDTO = new ResponseDTO("All data deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable int id) {
        log.debug("Retrieving employee by ID: {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        ResponseDTO responseDTO;
        HttpStatus status;
        if (employee != null) {
            log.info("Employee found. ID: {}", id);
            responseDTO = new ResponseDTO("User found", employee);
            status = HttpStatus.OK;
        } else {
            log.warn("Employee not found. ID: {}", id);
            responseDTO = new ResponseDTO("User not found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }



    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        log.debug("Retrieving all employees");
        List<Employee> employee = employeeService.getAllEmployee();
        ResponseDTO responseDTO;
        HttpStatus status;
        if (!employee.isEmpty()) {
            log.info("Employees found: {}", employee.size());
            responseDTO = new ResponseDTO("Employees found", employee);
            status = HttpStatus.OK;
        } else {
            log.warn("No employees found");
            responseDTO = new ResponseDTO("No employees found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }
}





