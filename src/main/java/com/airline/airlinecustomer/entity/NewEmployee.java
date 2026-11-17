package com.airline.airlinecustomer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "newemployee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private String gender;
    private String address;
}
