package com.AttendanceBase.service;

import com.AttendanceBase.modal.Employee;

import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    public Employee create(Employee employee);

    public Optional<Employee> readByID(Integer employeeID);

    public Set<Employee> readAll();

    public Employee update(Employee employee);

    public void delete(Employee employeeID);
}
