package com.airline.airlinecustomer.repository;

import com.airline.airlinecustomer.entity.Agents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agents, Long> {
}
