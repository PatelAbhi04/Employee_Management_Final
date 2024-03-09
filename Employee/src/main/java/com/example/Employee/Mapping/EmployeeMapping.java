package com.example.Employee.Mapping;


import com.example.Employee.dept.Employeedept;
import com.example.Employee.entity.Employee;

public class EmployeeMapping {

    public static Employeedept mapToEmployeedept(Employee employee){
        return new Employeedept(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(Employeedept employeedept){
        return new Employee(
                employeedept.getId(),
                employeedept.getFirstName(),
                employeedept.getLastName(),
                employeedept.getEmail()
        );
    }
}
