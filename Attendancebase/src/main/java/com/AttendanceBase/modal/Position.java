package com.AttendanceBase.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer positionID;
    private String employeeNumber;
    private String position;

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private Position() {

    }

    public Position(Builder builder)
    {
        this.positionID = builder.positionID;
        this.employeeNumber = builder.employeeNumber;
        this.position = builder.position;

    }

    public static class Builder{
        private Integer positionID;
        private String employeeNumber;
        private String position;

        public Builder positionID(Integer value)
        {
            this.positionID = value;
            return this;
        }

        public Builder employeeNumber(String value)
        {
            this.employeeNumber = value;
            return this;
        }

        public Builder position(String value)
        {
            this.position = value;
            return this;
        }

        public Builder copy(Position position) {
            this.positionID = position.positionID;
            this.employeeNumber = position.employeeNumber;
            this.position = position.position;
            return  this;
        }

        public Position build(){
            return new Position(this);
        }
    }
}

