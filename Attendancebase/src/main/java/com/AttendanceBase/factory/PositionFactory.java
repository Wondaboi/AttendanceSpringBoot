package com.AttendanceBase.factory;

import com.AttendanceBase.modal.Position;

import java.util.Map;

public class PositionFactory {
    public static Position getPosition(Integer positionID, String employeeNumber, String position)
    {
        Position factoryPosition = new Position.Builder()
                .positionID(positionID)
                .employeeNumber(employeeNumber)
                .position(position)
                .build();
        return factoryPosition;
    }
}
