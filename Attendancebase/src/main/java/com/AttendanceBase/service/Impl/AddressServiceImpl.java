package com.AttendanceBase.service.Impl;

import com.AttendanceBase.modal.Address;
import com.AttendanceBase.repository.AddressRepository;
import com.AttendanceBase.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(Address address)
    {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> readByID(Integer addressID)
    {
        return addressRepository.findById(addressID);
    }

    @Override
    public Set<Address> readAll()
    {
        Iterable<Address> addresses = addressRepository.findAll();
        Set addressSet = new HashSet();
        for(Address address:addresses)
        {
            addressSet.add(address);
        }
        return addressSet;
    }

    @Override
    public Address update(Address address)
    {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Address addressID)
    {
        addressRepository.delete(addressID);
    }
}
