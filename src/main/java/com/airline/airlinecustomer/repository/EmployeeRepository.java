package com.airline.airlinecustomer.repository;

import com.airline.airlinecustomer.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
