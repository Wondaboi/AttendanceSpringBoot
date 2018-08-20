package com.AttendanceBase.service.Impl;

import com.AttendanceBase.modal.Clock;
import com.AttendanceBase.repository.ClockRepository;
import com.AttendanceBase.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClockServiceImpl implements ClockService {

    @Autowired
    private ClockRepository clockRepository;

    @Override
    public Clock create(Clock clock)
    {
        return clockRepository.save(clock);
    }

    @Override
    public Optional<Clock> readByID(Integer clockID)
    {
        return clockRepository.findById(clockID);
    }

    @Override
    public Set<Clock> readAll()
    {
        Iterable<Clock> clocks = clockRepository.findAll();
        Set clockSet = new HashSet();
        for(Clock clock:clocks)
        {
            clockSet.add(clock);
        }
        return clockSet;
    }

    @Override
    public Clock update(Clock clock)
    {
        return clockRepository.save(clock);
    }

    @Override
    public void delete(Clock clockID)
    {
        clockRepository.delete(clockID);
    }
}
