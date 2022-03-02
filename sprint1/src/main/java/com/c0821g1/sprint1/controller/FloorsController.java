package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.service.impl.FloorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("floors")
public class FloorsController {
    @Autowired
    FloorServiceImpl floorService;

    /**
     * Created: DuyNP
     * Method: return list floors
     *
     * @return: ResponseEntity<>(floors, HttpStatus.OK)
     */
    @GetMapping("/list")
    public ResponseEntity<List<Floors>> findAllFloors() {
        List<Floors> floors = floorService.findAll();
        if (floors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    /**
     * Created: DuyNP
     * Method: delete floors
     * @param id
     * @return ResponseEntity<>(HttpStatus.OK)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Floors> deleteFloorsById(@PathVariable Integer id) {
        Optional<Floors> floors = floorService.findFloorsById(id);
        if (!floors.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        floorService.deleteFloorsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
