package com.example.Employee.service;

import com.example.Employee.dept.Employeedept;

import java.util.List;

public interface EmployeeService {



        Employeedept createEmployee(Employeedept employeeDto);

    Employeedept getEmployeeById(Long employeeId);

    List<Employeedept> getAllEmployees();


    Employeedept updateEmployee(Long employeeId, Employeedept updatedEmployee);

    void deleteEmployee(Long employeeId);


}
