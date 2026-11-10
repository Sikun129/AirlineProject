package com.airline.airlinecustomer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first name is mandatory")
    private String firstname;
    private String lastName;

    @NotBlank(message = "email id is mandatory")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "phone number is mandatory")
    private String phone;

    @NotBlank(message = "No Blank")
    private  String gender;

    private String address;

    private String city;

    private String booking_history;

    @NotBlank(message = "flyer_number is mandatory")
    private String flyer_number;


}
