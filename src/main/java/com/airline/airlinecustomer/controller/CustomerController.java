package com.airline.airlinecustomer.controller;

import com.airline.airlinecustomer.entity.Customer;
import com.airline.airlinecustomer.service.CustomerService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/cust")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getallCustomer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable Long id){
        return customerService.getCustomerId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PostMapping
    public ResponseEntity<Customer> CreateCustomer(@Valid @RequestBody Customer customer){
       Customer customers = customerService.CreateCustomer(customer);
       return ResponseEntity.status(HttpStatus.CREATED).body(customers);
    }

    @PutMapping
    public ResponseEntity<Customer> UpdateCustomer( @RequestBody Customer customerDetails ,
                                                              @PathVariable Long id){
      Customer customerss =  customerService.UpdateCustomer(id , customerDetails);
      return ResponseEntity.ok(customerss);
    }



    @DeleteMapping
    public ResponseEntity<Customer> DeleteCustomer(@PathVariable Long id){
        customerService.DeleteCustomer(id);
        return ResponseEntity.ok().build();
    }



}
