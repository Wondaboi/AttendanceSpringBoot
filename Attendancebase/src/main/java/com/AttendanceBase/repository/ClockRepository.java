package com.AttendanceBase.repository;

import com.AttendanceBase.modal.Clock;
import org.springframework.data.repository.CrudRepository;

public interface ClockRepository extends CrudRepository<Clock, Integer> {
}
