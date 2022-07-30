package com.example.lms_Clone.services;

import com.example.lms_Clone.Exception.UserNotFound;
import com.example.lms_Clone.model.Address;
import com.example.lms_Clone.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address addAddress(Address address){
        return this.addressRepo.save(address);
    }

    public Address findAddressById(Long id){
        return addressRepo.findById(id).orElseThrow(()->new UserNotFound("User Not Found"));
    }

    public Address updateAddress(Address address){
        return  this.addressRepo.save(address);
    }
    public void deleteAddress(Long id){
        this.addressRepo.deleteById(id);
    }
}
