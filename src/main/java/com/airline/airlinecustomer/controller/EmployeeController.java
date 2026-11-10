package com.airline.airlinecustomer.controller;

import com.airline.airlinecustomer.entity.Employee;
import com.airline.airlinecustomer.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getallEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeID(@PathVariable Long id){
        return employeeService.getEmployeeID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
       Employee employee1 = employeeService.createEmployee(employee);
       return ResponseEntity.status(HttpStatus.CREATED).body(employee1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employeedetails,
                                                   @PathVariable Long id){
      Employee employee =  employeeService.updateEmployee(id, employeedetails);
      return ResponseEntity.ok(employee);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();

    }
}
