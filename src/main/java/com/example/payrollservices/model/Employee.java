package com.example.payrollservices.model;

import com.example.payrollservices.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int id;
   // @Column(name = "firstName")
    private String fName;
  //  @Column(name = "lastName")
    private String lName;
   // @Column(name = "emp_email")
    private String email;
   // @Column(name = "phoneNumber")
    private String phoneNumber;
  //  @Column(name = "address")
    private String address;
  //  @Column(name = "salary")
    private double salary;
  //  @Column(name = "gender")
    private String gender;
  //  @Column(name = "startDate")
    private String startDate;
  //  @Column(name = "note")
    private String note;
   // @Column(name = "ProfilePic")
    private String profilePic;


//    @OneToMany
//    @JoinColumn(name = "list_id")
//    private List<Dept> dept;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public Employee(EmployeeDTO employeeDTO) {
        this.updateEmployee(employeeDTO);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        this.fName = employeeDTO.getFName();
        this.lName = employeeDTO.getLName();
        this.email = employeeDTO.getEmail();
        this.phoneNumber = employeeDTO.getPhoneNumber();
        this.address = employeeDTO.getAddress();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.startDate = employeeDTO.getStartDate();
        this.note = employeeDTO.getNote();
        this.profilePic = employeeDTO.getProfilePic();
        this.departments = employeeDTO.getDepartments();
        //  this.dept = employeeDTO.getDept();
    }

}
