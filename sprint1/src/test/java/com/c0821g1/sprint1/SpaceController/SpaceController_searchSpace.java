package com.c0821g1.sprint1.SpaceController;

import com.c0821g1.sprint1.controller.SpaceController;
import com.c0821g1.sprint1.entity.space.Spaces;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SpaceController_searchSpace {

    @Autowired
    private SpaceController spaceController;
    //test case: trường hợp tìm kiếm có tham số.
    @Test
    public void searchContractName() {
        ResponseEntity<Page<Spaces>> responseEntity
                = (ResponseEntity<Page<Spaces>>) spaceController.searchSpace("tầng 1", "MB-003", "312", "Mặt đứng","Đã vào ở", PageRequest.of(0,2));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("tầng 1", responseEntity.getBody().getContent().get(0).getFloors().getFloorName());
    }

}
