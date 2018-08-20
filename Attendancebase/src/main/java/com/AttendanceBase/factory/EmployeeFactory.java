package com.AttendanceBase.factory;

import com.AttendanceBase.modal.Employee;

import java.util.Map;

public class EmployeeFactory {
    public static Employee getEmployee(Integer employeeID, String employeeNumber, String name, String surname) {
        Employee factoryEmployee = new Employee.Builder()
                .employeeID(employeeID)
                .employeeNumber(employeeNumber)
                .name(name)
                .surname(surname)
                .build();
        return factoryEmployee;
    }
}