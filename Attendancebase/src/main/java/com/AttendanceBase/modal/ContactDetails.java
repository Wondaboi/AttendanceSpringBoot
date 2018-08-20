package com.AttendanceBase.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ContactDetails implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer contactDetailsID;
    private String employeeNumber;
    private String contactDetails;


    public Integer getContactDetailsID() {
        return contactDetailsID;
    }

    public void setContactDetailsID(Integer contactDetailsID) {
        this.contactDetailsID = contactDetailsID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    private ContactDetails(Builder builder)
    {
        this.contactDetailsID = builder.contactDetailsID;
        this.employeeNumber = builder.employeeNumber;
        this.contactDetails = builder.contactDetails;

    }

    private ContactDetails() {

    }

    public static class Builder{
        private Integer contactDetailsID;
        private String employeeNumber;
        private String contactDetails;

        public Builder contactDetailsID(Integer value)
        {
            this.contactDetailsID = value;
            return this;
        }

        public Builder employeeNumber(String value)
        {
            this.employeeNumber = value;
            return this;
        }

        public Builder contactDetails(String value)
        {
            this.contactDetails = value;
            return this;
        }

        public Builder copy(ContactDetails contactDetails) {
            this.contactDetailsID = contactDetails.contactDetailsID;
            this.employeeNumber = contactDetails.employeeNumber;
            this.contactDetails = contactDetails.contactDetails;
            return  this;
        }

        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }
}
