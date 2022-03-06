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
public class SpaceController_findAllSpace {
    @Autowired
    private SpaceController spaceController;

    // test case: trường hợp Trả về list có size = 0.
    @Test
    public void findAllSpace_5() throws Exception {
        ResponseEntity<List<SpaceListDTO>> responseEntity =
                 this.spaceController.findAllSpace(PageRequest.of(0, 0));
        Assertions.assertEquals(204  , responseEntity.getStatusCodeValue());
    }

    //test case: trường hợp Trả về list có size > 0.
    @Test
    public void findAllSpace_6() throws Exception {
        ResponseEntity<List<SpaceListDTO>> responseEntity =
                this.spaceController.findAllSpace(PageRequest.of(1, 2));
        Assertions.assertEquals(200  , responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals(3, responseEntity.getBody().getContent().get(0).getSpaceId());
//        Assertions.assertEquals("MB-003", responseEntity.getBody().getContent().get(0).getSpaceCode());
//        Assertions.assertEquals("Mặt đứng", responseEntity.getBody().getContent().get(0).getSpacesType().getSpaceTypeName());
//        Assertions.assertEquals("312", responseEntity.getBody().getContent().get(0).getSpaceArea());
//        Assertions.assertEquals("Đã vào ở", responseEntity.getBody().getContent().get(0).getSpaceStatus().getSpacerStatusName());
//        Assertions.assertEquals("1000", responseEntity.getBody().getContent().get(0).getSpaceManagerFee());
//        Assertions.assertEquals("10,000,000", responseEntity.getBody().getContent().get(0).getSpacePrice());
    }
}
