package com.airline.airlinecustomer.repository;

import com.airline.airlinecustomer.entity.SecurityStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<SecurityStaff, Long> {
}
