package com.c0821g1.sprint1.space_controller;

import com.c0821g1.sprint1.controller.SpaceController;
import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.entity.space.Spaces;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class SpaceController_searchSpace {

//    @Autowired
//    private SpaceController spaceController;
    //test case: trường hợp tìm kiếm có tham số.
//    @Test
//    public void searchContractName() {
//        ResponseEntity<List<SpaceListDTO>> responseEntity
//                = (ResponseEntity<List<SpaceListDTO>>) spaceController.searchSpace("tầng 1", "MB-003", "312", "Mặt đứng","Đã vào ở", PageRequest.of(0,2));
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("tầng 1", responseEntity.getBody().getContent().get(0).getFloors().getFloorName());
//        Assertions.assertEquals("MB-003", responseEntity.getBody().getContent().get(0).getSpaceCode());
//        Assertions.assertEquals("312", responseEntity.getBody().getContent().get(0).getSpaceArea());
//        Assertions.assertEquals("Mặt đứng", responseEntity.getBody().getContent().get(0).getSpacePrice());
//        Assertions.assertEquals("Đã vào ở", responseEntity.getBody().getContent().get(0).getSpaceStatus().getSpacerStatusName());

//    }

}
