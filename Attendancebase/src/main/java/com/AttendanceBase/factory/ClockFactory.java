package com.AttendanceBase.factory;


import com.AttendanceBase.modal.Clock;

import java.util.Map;

public class ClockFactory {
    public static Clock getClock(Integer clockID, String employeeNumber, String clocked)
    {
        Clock factoryClock = new Clock.Builder()
                .clockID(clockID)
                .employeeNumber(employeeNumber)
                .clocked(clocked)
                .build();
        return factoryClock;
    }
}
