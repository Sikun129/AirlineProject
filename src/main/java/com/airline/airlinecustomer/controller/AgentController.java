package com.airline.airlinecustomer.controller;

import com.airline.airlinecustomer.entity.Agents;
import com.airline.airlinecustomer.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping
    public List<Agents> allAgents(){
        return agentService.getallAgents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Agents> getid(@PathVariable Long id){
     return   agentService.getAgentid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Agents> createAgent(@RequestBody Agents agents){
     Agents agents1 =   agentService.create(agents);
     return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Agents> updateAgent(@RequestBody Agents agentsdetails ,
                                              @PathVariable Long id){
       Agents agent = agentService.update(id ,agentsdetails);
       return ResponseEntity.ok(agent);

    }
}
