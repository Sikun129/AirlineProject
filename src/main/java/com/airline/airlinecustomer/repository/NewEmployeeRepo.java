package com.airline.airlinecustomer.repository;

import com.airline.airlinecustomer.entity.NewEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEmployeeRepo extends JpaRepository<NewEmployee, Long> {
}
