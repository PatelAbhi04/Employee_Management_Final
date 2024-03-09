package com.example.Employee.controller;

import com.example.Employee.dept.Employeedept;
import com.example.Employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<Employeedept> createEmployee(@RequestBody Employeedept employeedept) {
        Employeedept savedEmployee = employeeService.createEmployee(employeedept);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employeedept> getEmployeeById(@PathVariable("id") Long employeeId){
        Employeedept employeedept = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeedept);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<Employeedept>> getAllEmployees(){
        List<Employeedept> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }

   //update employee
    @PutMapping("{id}")
    public ResponseEntity<Employeedept> updateEmployee(@PathVariable("id") Long employeeId,
                                                       @RequestBody Employeedept updatedEmployee){
        Employeedept employeedept = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeedept);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
