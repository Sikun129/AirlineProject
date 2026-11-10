package com.airline.airlinecustomer.service;

import com.airline.airlinecustomer.entity.Customer;
import com.airline.airlinecustomer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;


    public List<Customer> getallCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerId(Long id){
        return customerRepository.findById(id);
    }

//    public   Customer save(Customer customer){
//        return customerRepository.save(customer);
//    }

//                                OR

    public Customer CreateCustomer(Customer customer){
        return customerRepository.save(customer);
    }


    public Customer UpdateCustomer(Long id, Customer customerDetails){
        Customer customers = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer Not Found"+id));

        customers.setFirstname(customerDetails.getFirstname());
        customers.setLastName(customerDetails.getLastName());
        customers.setEmail(customerDetails.getEmail());
        customers.setPhone(customerDetails.getPhone());
        customers.setGender(customerDetails.getGender());
        customers.setAddress(customerDetails.getAddress());
        customers.setCity(customerDetails.getCity());
        customers.setBooking_history(customerDetails.getBooking_history());
        customers.setFlyer_number(customerDetails.getFlyer_number());

        return customerRepository.save(customers);

    }


    public Customer DeleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found" + id));
        customerRepository.delete(customer);
        return customer;


    }
}
