package com.AttendanceBase.controller;

import com.AttendanceBase.modal.Clock;
import com.AttendanceBase.modal.Clock;
import com.AttendanceBase.service.Impl.ClockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/clock")
public class ClockController {

    @Autowired
    private ClockServiceImpl clockService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Clock> getAllClock()
    {
        return clockService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addClock(@RequestBody Clock clock){
        if(StringUtils.isEmpty(clock.getEmployeeNumber()) || StringUtils.isEmpty(clock.getClocked()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        clockService.create(clock);
        return new ResponseEntity(clock, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findClock(@PathVariable("id") Integer id)
    {
        Optional<Clock> clock = clockService.readByID(id);

        if(!clock.isPresent())
        {
            return new ResponseEntity("No clock found for clock " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(clock, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updateClock(@RequestBody Clock clock)
    {
        if(StringUtils.isEmpty(clock.getEmployeeNumber()) || StringUtils.isEmpty(clock.getClocked()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        clockService.update(clock);
        return new ResponseEntity(clock, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{clockID}", method = RequestMethod.DELETE)
    public void deleteClock(@PathVariable Clock clockID)
    {
        clockService.delete(clockID);
    }
}
