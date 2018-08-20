package com.AttendanceBase.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Clock implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clockID;
    private String employeeNumber;
    private String clocked;

    public Integer getclockID() {
        return clockID;
    }

    public void setId(Integer clockID) {
        this.clockID = clockID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getClocked() {
        return clocked;
    }

    public void setClockIn(String clockIn) {
        this.clocked = clocked;
    }

    private Clock() {

    }

    private Clock(Builder builder)
    {
        this.clockID = builder.clockID;
        this.employeeNumber = builder.employeeNumber;
        this.clocked = builder.clocked;


    }

    public static class Builder{
        private Integer clockID;
        private String employeeNumber;
        private String clocked;

        public Builder clockID(Integer value)
        {
            this.clockID = value;
            return this;
        }

        public Builder employeeNumber(String value)
        {
            this.employeeNumber = value;
            return this;
        }

        public Builder clocked(String value)
        {
            this.clocked = value;
            return this;
        }

        public Builder copy(Clock clock) {
            this.clockID = clock.clockID;
            this.employeeNumber = clock.employeeNumber;
            this.clocked = clock.clocked;
            return  this;
        }

        public Clock build(){
            return new Clock(this);
        }
    }

}
