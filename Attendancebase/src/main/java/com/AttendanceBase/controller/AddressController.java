package com.AttendanceBase.controller;

import com.AttendanceBase.modal.Address;
import com.AttendanceBase.service.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Address> getAllAddress()
    {
        return addressService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addAddress(@RequestBody Address address){
        if(StringUtils.isEmpty(address.getEmployeeNumber()) || StringUtils.isEmpty(address.getAddress()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        addressService.create(address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{addressID}")
    public @ResponseBody ResponseEntity
    findAddress(@PathVariable("addressID") Integer addressID)
    {
        Optional<Address> address = addressService.readByID(addressID);

        if(!address.isPresent())
        {
            return new ResponseEntity("No address found for address " + addressID, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updateAddress(@RequestBody Address address)
    {
        if(StringUtils.isEmpty(address.getEmployeeNumber()) || StringUtils.isEmpty(address.getAddress()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        addressService.update(address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{addressID}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable Address addressID)
    {
        addressService.delete(addressID);
    }
}
