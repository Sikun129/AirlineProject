package com.airline.airlinecustomer.service;

import com.airline.airlinecustomer.entity.NewEmployee;
import com.airline.airlinecustomer.repository.NewEmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewEmployeeService {

    @Autowired
    private NewEmployeeRepo newEmpRepo;

    public List<NewEmployee> getallemp(){
        return newEmpRepo.findAll();
    }

    public NewEmployee createEmp(NewEmployee newEmployee){
        return newEmpRepo.save(newEmployee);
    }
}
