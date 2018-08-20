package com.AttendanceBase.service.Impl;

import com.AttendanceBase.modal.Employee;
import com.AttendanceBase.repository.EmployeeRepository;
import com.AttendanceBase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> readByID(Integer employeeID)
    {
        return employeeRepository.findById(employeeID);
    }

    @Override
    public Set<Employee> readAll()
    {
        Iterable<Employee> employees = employeeRepository.findAll();
        Set employeeSet = new HashSet();
        for(Employee employee:employees)
        {
            employeeSet.add(employee);
        }
        return employeeSet;
    }

    @Override
    public Employee update(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employeeID)
    {
        employeeRepository.delete(employeeID);
    }
}
