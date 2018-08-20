package com.AttendanceBase.repository;

import com.AttendanceBase.modal.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
