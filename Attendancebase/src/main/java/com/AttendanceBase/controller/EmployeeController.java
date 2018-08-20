package com.AttendanceBase.controller;

import com.AttendanceBase.modal.Employee;
import com.AttendanceBase.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Employee> getAllEmployee()
    {
        return employeeService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        if(StringUtils.isEmpty(employee.getEmployeeNumber()) || StringUtils.isEmpty(employee.getName()) || StringUtils.isEmpty(employee.getSurname()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        employeeService.create(employee);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findEmployee(@PathVariable("id") Integer id)
    {
        Optional<Employee> employee = employeeService.readByID(id);

        if(!employee.isPresent())
        {
            return new ResponseEntity("No employee found for employee " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(@RequestBody Employee employee)
    {
        if(StringUtils.isEmpty(employee.getEmployeeNumber()) || StringUtils.isEmpty(employee.getName()) || StringUtils.isEmpty(employee.getSurname()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        employeeService.update(employee);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{employeeID}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Employee employeeID)
    {
        employeeService.delete(employeeID);
    }
}
