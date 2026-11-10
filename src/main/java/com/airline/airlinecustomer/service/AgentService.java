package com.airline.airlinecustomer.service;

import com.airline.airlinecustomer.entity.Agents;
import com.airline.airlinecustomer.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public List<Agents> getallAgents(){
        return agentRepository.findAll();
    }

   public Optional<Agents> getAgentid(Long id){
        return agentRepository.findById(id);
   }

    public Agents create(Agents agents){
        return agentRepository.save(agents);
    }

    public Agents update(Long id, Agents agentsdetails){
       Agents agents = agentRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Agent not found"+id));

       agents.setName(agentsdetails.getName());
       agents.setEmail(agentsdetails.getEmail());
       agents.setPhone(agentsdetails.getPhone());
       agents.setGender(agentsdetails.getGender());
       agents.setAddress(agentsdetails.getAddress());
       agents.setCity(agentsdetails.getCity());
       return agentRepository.save(agents);
    }


}
