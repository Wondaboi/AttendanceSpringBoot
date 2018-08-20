package com.AttendanceBase.controller;

import com.AttendanceBase.modal.ContactDetails;
import com.AttendanceBase.modal.ContactDetails;
import com.AttendanceBase.service.Impl.ContactDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/contactDetails")
public class ContactDetailsController {

    @Autowired
    private ContactDetailsServiceImpl contactDetailsService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<ContactDetails> getAllContactDetails()
    {
        return contactDetailsService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addContactDetails(@RequestBody ContactDetails contactDetails){
        if(StringUtils.isEmpty(contactDetails.getEmployeeNumber()) || StringUtils.isEmpty(contactDetails.getContactDetails()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        contactDetailsService.create(contactDetails);
        return new ResponseEntity(contactDetails, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findContactDetails(@PathVariable("id") Integer id)
    {
        Optional<ContactDetails> contactDetails = contactDetailsService.readByID(id);

        if(!contactDetails.isPresent())
        {
            return new ResponseEntity("No contactDetails found for contactDetails " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(contactDetails, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updateContactDetails(@RequestBody ContactDetails contactDetails)
    {
        if(StringUtils.isEmpty(contactDetails.getEmployeeNumber()) || StringUtils.isEmpty(contactDetails.getContactDetails()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        contactDetailsService.update(contactDetails);
        return new ResponseEntity(contactDetails, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{contactDetailsID}", method = RequestMethod.DELETE)
    public void deleteContactDetails(@PathVariable ContactDetails contactDetailsID)
    {
        contactDetailsService.delete(contactDetailsID);
    }
}
