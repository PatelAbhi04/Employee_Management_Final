package com.example.Employee.service.impl;

import com.example.Employee.Mapping.EmployeeMapping;
import com.example.Employee.dept.Employeedept;
import com.example.Employee.entity.Employee;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employeedept createEmployee(Employeedept employeedept) {

        Employee employee = EmployeeMapping.mapToEmployee(employeedept);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapping.mapToEmployeedept(savedEmployee);

    }

    @Override
    public Employeedept getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        return EmployeeMapping.mapToEmployeedept(employee);
    }

    @Override
    public List<Employeedept> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapping.mapToEmployeedept(employee))
                .collect(Collectors.toList());
    }

    @Override
    public Employeedept updateEmployee(Long employeeId, Employeedept updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapping.mapToEmployeedept(updatedEmployeeObj);
    }



    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }



}
