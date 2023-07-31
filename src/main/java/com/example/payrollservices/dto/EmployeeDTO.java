package com.example.payrollservices.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee first invalid")
    public String fName;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee Lastname invalid")
    public String lName;

    @NotEmpty
    public String address;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email are not matching invalid")
    public String email;

    @Pattern(regexp = "^(?:(?:\\+91)|(?:91)|(?:0))[7-9][0-9]{9}$", message = "mobile number invalid this is not indian mobile number")
    public String phoneNumber;

    @Min(value = 1500, message = "min wage should be more than 15000")
    @Max(value = 200000, message = "man wage should be less than 2000000")
    public double salary;

    @Pattern(regexp = "male|female", message = "gender need to be male or female")
    public String gender;

    // @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDAte should not be empty")
    //@PostOrPresent
    public String startDate;

    @NotBlank(message = "Note can not be empty")
    public String note;

    @NotBlank(message = "ProfilePic can not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
    public List<String> departments;

    // public List<Dept>dept;


}
