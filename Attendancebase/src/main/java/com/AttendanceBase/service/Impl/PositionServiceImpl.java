package com.AttendanceBase.service.Impl;

import com.AttendanceBase.modal.Position;
import com.AttendanceBase.repository.PositionRepository;
import com.AttendanceBase.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position create(Position position)
    {
        return positionRepository.save(position);
    }

    @Override
    public Optional<Position> readByID(Integer positionID)
    {
        return positionRepository.findById(positionID);
    }

    @Override
    public Set<Position> readAll()
    {
        Iterable<Position> positions = positionRepository.findAll();
        Set positionSet = new HashSet();
        for(Position position:positions)
        {
            positionSet.add(position);
        }
        return positionSet;
    }

    @Override
    public Position update(Position position)
    {
        return positionRepository.save(position);
    }

    @Override
    public void delete(Position positionID)
    {
        positionRepository.delete(positionID);
    }
}
