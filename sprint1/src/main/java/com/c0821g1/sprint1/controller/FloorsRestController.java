package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.floors.Floors;
import com.c0821g1.sprint1.service.impl.FloorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "floors")
public class FloorsRestController {
    @Autowired
    FloorServiceImpl floorService;
    /**
     * Created: DuyNP
     * Method: return Page floors
     * @param pageable
     * @returnResponseEntity<>(floors, HttpStatus.OK)
     */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Floors>> findAllFloors(@PageableDefault(size = 2) Pageable pageable) {
        Page<Floors> floors = this.floorService.findAllFloors(pageable);
        if (floors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    /**
     * Created: DuyNP
     * Method: delete floors by id
     * @param id
     * @return ResponseEntity<>(HttpStatus.OK)
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Floors> deleteFloorsById(@PathVariable Integer id) {
        Optional<Floors> floors = this.floorService.findFloorsById(id);
        if (!floors.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.floorService.deleteFloorsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created: DuyNP
     * Method: delete flag floors by id
     * @param id
     * @return ResponseEntity<>(floors,HttpStatus.OK);
     */

    @PatchMapping(value = "/delete-flag/{id}")
    public ResponseEntity<Floors> deleteFlagFloorsById(@PathVariable Integer id) {
        Floors floors = this.floorService.findById(id);
        if (floors==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        floors.setFloorDeleteFlag(0);
        this.floorService.editFloors(floors);

        return new ResponseEntity<>(floors,HttpStatus.OK);
    }
}
