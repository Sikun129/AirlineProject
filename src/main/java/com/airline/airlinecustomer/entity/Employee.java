package com.airline.airlinecustomer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emplyee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empid;

    @NotBlank(message = "first name is Mandatory")
    private String firstname;

    private String lastname;

    @Email(message = "mail is a mandatory")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "phone number is mandatory")
    private String phone;

    private  String gender;


    private String address;

    private String city;
    private String state;
    private String zip;

}
