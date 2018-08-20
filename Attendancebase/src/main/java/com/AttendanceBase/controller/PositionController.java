package com.AttendanceBase.controller;

import com.AttendanceBase.modal.Position;
import com.AttendanceBase.service.Impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/position")
public class PositionController {

    @Autowired
    private PositionServiceImpl positionService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<Position> getAllPosition()
    {
        return positionService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addPosition(@RequestBody Position position){
        if(StringUtils.isEmpty(position.getEmployeeNumber()) || StringUtils.isEmpty(position.getPosition()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        positionService.create(position);
        return new ResponseEntity(position, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findPosition(@PathVariable("id") Integer id)
    {
        Optional<Position> position = positionService.readByID(id);

        if(!position.isPresent())
        {
            return new ResponseEntity("No position found for position " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(position, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updatePosition(@RequestBody Position position)
    {
        if(StringUtils.isEmpty(position.getEmployeeNumber()) || StringUtils.isEmpty(position.getPosition()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        positionService.update(position);
        return new ResponseEntity(position, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{positionID}", method = RequestMethod.DELETE)
    public void deletePosition(@PathVariable Position positionID)
    {
        positionService.delete(positionID);
    }
}
