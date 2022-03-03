package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.floors.Floors;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

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

        ResponseEntity<Page<Floors>> responseEntity
                = this.floorsRestController.findAllFloors(PageRequest.of(0, 2));

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /**
     * Create:DuyNP
     * Method: Test page floors size > 0
     */
    @Test
    public void findAllFloors_6() {
        ResponseEntity<Page<Floors>> responseEntity
                = this.floorsRestController.findAllFloors(PageRequest.of(0, 2));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Tầng 2",
                responseEntity.getBody().getContent().get(1).getFloorName());
        Assertions.assertEquals("MTL002",
                responseEntity.getBody().getContent().get(1).getFloorCode());
        Assertions.assertEquals(200.0,
                responseEntity.getBody().getContent().get(1).getFloorArea());
        Assertions.assertEquals(20,
                responseEntity.getBody().getContent().get(1).getFloorCapacity());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getFloorDeleteFlag());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getFloorId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getFloorsStatus().getFloorStatusId());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(1).getFloorsType().getFloorTypeId());

    }
}
