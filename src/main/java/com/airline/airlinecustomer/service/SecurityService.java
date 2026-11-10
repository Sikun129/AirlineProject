package com.airline.airlinecustomer.service;

import com.airline.airlinecustomer.entity.SecurityStaff;
import com.airline.airlinecustomer.repository.SecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;

    public List<SecurityStaff> getallSecurityStaff() {
        return securityRepository.findAll();
    }

    public Optional<SecurityStaff> getSecurityStaffById(Long id) {
        return securityRepository.findById(id);
    }

    public SecurityStaff create(SecurityStaff securityStaffs) {
       SecurityStaff securityStaff1 = securityRepository.save(securityStaffs);
       return securityStaff1;
    }

   public SecurityStaff update(Long id, SecurityStaff securityStaffs) {
     SecurityStaff staff =   securityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("SecurityStaff not found"+id));
     staff.setFirstname(securityStaffs.getFirstname());
     staff.setLastname(securityStaffs.getLastname());
     staff.setEmail(securityStaffs.getEmail());
     staff.setPhone(securityStaffs.getPhone());
     staff.setGender(securityStaffs.getGender());
     staff.setAddress(securityStaffs.getAddress());
     staff.setCity(securityStaffs.getCity());
     staff.setState(securityStaffs.getState());
     return securityRepository.save(staff);
   }
   public void delete(Long id){
    SecurityStaff staff =    securityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("SecurityStaff not found"+id));
   }
}
