package com.AttendanceBase.modal;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer addressID;
    private String employeeNumber;
    private String address;

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Address() {

    }

    public Address(Builder builder)
    {
        this.addressID = builder.addressID;
        this.employeeNumber = builder.employeeNumber;
        this.address = builder.address;

    }

    public static class Builder{
        private Integer addressID;
        private String employeeNumber;
        private String address;

        public Builder addressID(Integer value)
        {
            this.addressID = value;
            return this;
        }

        public Builder employeeNumber(String value)
        {
            this.employeeNumber = value;
            return this;
        }

        public Builder address(String value)
        {
            this.address = value;
            return this;
        }

        public Builder copy(Address address) {
            this.addressID = address.addressID;
            this.employeeNumber = address.employeeNumber;
            this.address = address.address;
            return  this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}