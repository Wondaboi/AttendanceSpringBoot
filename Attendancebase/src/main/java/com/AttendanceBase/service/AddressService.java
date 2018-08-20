package com.AttendanceBase.service;

import com.AttendanceBase.modal.Address;

import java.util.Optional;
import java.util.Set;

public interface AddressService {
    public Address create(Address address);

    public Optional<Address> readByID(Integer addressID);

    public Set<Address> readAll();

    public Address update(Address address);

    public void delete(Address addressID);
}
