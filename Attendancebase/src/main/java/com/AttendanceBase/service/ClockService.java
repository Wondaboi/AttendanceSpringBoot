package com.AttendanceBase.service;

import com.AttendanceBase.modal.Clock;

import java.util.Optional;
import java.util.Set;

public interface ClockService {
    public Clock create(Clock clock);

    public Optional<Clock> readByID(Integer clockID);

    public Set<Clock> readAll();

    public Clock update(Clock clock);

    public void delete(Clock clockID);
}
