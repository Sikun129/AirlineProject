package com.airline.airlinecustomer.controller;

import com.airline.airlinecustomer.entity.SecurityStaff;
import com.airline.airlinecustomer.service.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secu")
public class SecurityController {

    @Autowired
    private  SecurityService securityService;

    @GetMapping
    public List<SecurityStaff> getallstaff(){
        return securityService.getallSecurityStaff();
    }

    @GetMapping("{id}")
    public ResponseEntity<SecurityStaff> getstaffid(@PathVariable Long id){
        return securityService.getSecurityStaffById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<SecurityStaff> createSecurityStaff(@Valid @RequestBody SecurityStaff securityStaff) {
        SecurityStaff staff =  securityService.create(securityStaff);
        return ResponseEntity.status(HttpStatus.CREATED).body(staff);
    }

    @PutMapping("{id}")
    public ResponseEntity<SecurityStaff> updates(@PathVariable Long id,
                                                 @Valid @RequestBody SecurityStaff securityStaff) {
        SecurityStaff staff =  securityService.update(id, securityStaff);
        return ResponseEntity.ok(staff);
    }
    @DeleteMapping
    public ResponseEntity<SecurityStaff> detetSecuritystaff(@PathVariable Long id){
       securityService.delete(id);
     return ResponseEntity.ok().build();
    }
}
