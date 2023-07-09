package com.example.payrollservices.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDTO {
    @Pattern( regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$",message = "Employee name invalid")
    private String name;

    @NotEmpty
    private String address;


}
