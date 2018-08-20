package com.AttendanceBase.factory;

import com.AttendanceBase.modal.ContactDetails;

import java.util.Map;

public class ContactDetailsFactory {
    public static ContactDetails getContactDetails(Integer contactDetailsID, String employeeNumber, String contactDetails)
    {
        ContactDetails factoryContactDetails = new ContactDetails.Builder()
                .contactDetailsID(contactDetailsID)
                .employeeNumber(employeeNumber)
                .contactDetails(contactDetails)
                .build();
        return factoryContactDetails;
    }
}
