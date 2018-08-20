package com.AttendanceBase.service;

import com.AttendanceBase.modal.ContactDetails;

import java.util.Optional;
import java.util.Set;

public interface ContactDetailsService {
    public ContactDetails create(ContactDetails contactDetails);

    public Optional<ContactDetails> readByID(Integer contactDetailsID);

    public Set<ContactDetails> readAll();

    public ContactDetails update(ContactDetails contactDetails);

    public void delete(ContactDetails contactDetailsID);
}
