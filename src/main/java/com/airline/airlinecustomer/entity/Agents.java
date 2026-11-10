package com.airline.airlinecustomer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Brokers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is a manadatory")
    private String name;

    @NotBlank(message = "email id is a mandatory")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phone;

    @NotBlank(message = "it's is a mandatory")
    private String gender;

    private String address;
    private String city;


}
