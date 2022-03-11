package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.floors.Floors;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class FloorsRestController_findAllFloors {


    @Autowired
    FloorsRestController floorsRestController;

    /**
     * Create:DuyNP
     * Method: Test page floors size = 0
     */
    @Test
    public void findAllFloors_5() {

        ResponseEntity<List<Floors>> responseEntity
                = this.floorsRestController.findAllFloors();

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Create:DuyNP
     * Method: Test page floors size > 0
     */
    @Test
    public void findAllFloors_6() {
        ResponseEntity<List<Floors>> responseEntity
                = this.floorsRestController.findAllFloors();

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().size());
        Assertions.assertEquals("Tầng 2",
                responseEntity.getBody().get(1).getFloorName());
        Assertions.assertEquals("MTL002",
                responseEntity.getBody().get(1).getFloorCode());
        Assertions.assertEquals(200.0,
                responseEntity.getBody().get(1).getFloorArea());
        Assertions.assertEquals(20,
                responseEntity.getBody().get(1).getFloorCapacity());
        Assertions.assertEquals(1,
                responseEntity.getBody().get(1).getFloorDeleteFlag());
        Assertions.assertEquals(2,
                responseEntity.getBody().get(1).getFloorId());
        Assertions.assertEquals(2,
                responseEntity.getBody().get(1).getFloorsStatus().getFloorStatusId());
        Assertions.assertEquals(2,
                responseEntity.getBody().get(1).getFloorsType().getFloorTypeId());

    }
}
