package com.airline.airlinecustomer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecurityStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String firstname;

    private String lastname;

    @NotBlank(message = "email id is a mandatory")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "phone number is a mandatory")
    private String gender;

    private String phone;
    private String address;
    private String city;
    private String state;



}
