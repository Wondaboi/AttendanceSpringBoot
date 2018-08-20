package com.AttendanceBase.service;

import com.AttendanceBase.modal.Position;

import java.util.Optional;
import java.util.Set;

public interface PositionService {
    public Position create(Position position);

    public Optional<Position> readByID(Integer positionID);

    public Set<Position> readAll();

    public Position update(Position position);

    public void delete(Position positionID);
}
