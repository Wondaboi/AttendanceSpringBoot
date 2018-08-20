package com.AttendanceBase.factory;

import com.AttendanceBase.modal.Address;
import java.util.Map;

public class AddressFactory {

    public static Address getAddress(Integer addressID, String employeeNumber, String address)
    {
        Address factoryAddress = new Address.Builder()
                .addressID(addressID)
                .employeeNumber(employeeNumber)
                .address(address)
                .build();
        return factoryAddress;
    }
}
