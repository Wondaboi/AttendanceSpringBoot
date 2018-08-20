package com.AttendanceBase.service.Impl;

import com.AttendanceBase.modal.ContactDetails;
import com.AttendanceBase.repository.ContactDetailsRepository;
import com.AttendanceBase.service.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Override
    public ContactDetails create(ContactDetails contactDetails)
    {
        return contactDetailsRepository.save(contactDetails);
    }

    @Override
    public Optional<ContactDetails> readByID(Integer contactDetailsID)
    {
        return contactDetailsRepository.findById(contactDetailsID);
    }

    @Override
    public Set<ContactDetails> readAll()
    {
        Iterable<ContactDetails> details = contactDetailsRepository.findAll();
        Set contactDetailsSet = new HashSet();
        for(ContactDetails contactDetails:details)
        {
            contactDetailsSet.add(contactDetails);
        }
        return contactDetailsSet;
    }

    @Override
    public ContactDetails update(ContactDetails contactDetails)
    {
        return contactDetailsRepository.save(contactDetails);
    }

    @Override
    public void delete(ContactDetails contactDetailsID)
    {
        contactDetailsRepository.delete(contactDetailsID);
    }
}
