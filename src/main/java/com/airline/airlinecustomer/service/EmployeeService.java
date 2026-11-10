package com.airline.airlinecustomer.service;

import com.airline.airlinecustomer.entity.Employee;
import com.airline.airlinecustomer.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public List<Employee> getallEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeID(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id ,Employee employeeDetails) {
      Employee employees =  employeeRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("Employee Not Found" + id));

      employees.setFirstname(employeeDetails.getFirstname());
      employees.setLastname(employeeDetails.getLastname());
      employees.setEmail(employeeDetails.getEmail());
      employees.setPhone(employeeDetails.getPhone());
      employees.setGender(employeeDetails.getGender());
      employees.setAddress(employeeDetails.getAddress());
      employees.setCity(employeeDetails.getCity());
      employees.setState(employeeDetails.getState());
      employees.setZip(employeeDetails.getZip());

        return employeeRepository.save(employees);
    }

    public void deleteEmployee(Long id) {
      Employee employee =  employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee Not Found" + id));
      employeeRepository.delete(employee);


    }
}
