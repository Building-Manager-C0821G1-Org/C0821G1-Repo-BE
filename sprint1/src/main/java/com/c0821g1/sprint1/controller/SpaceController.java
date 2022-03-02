package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.service.SpaceService;
import com.c0821g1.sprint1.service.SpaceStatusService;
import com.c0821g1.sprint1.service.SpaceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping (value = "/space")
public class SpaceController {

    @Autowired
    SpaceService spaceService;

    @Autowired
    SpaceTypeService spaceTypeService;

    @Autowired
    SpaceStatusService spaceStatusService;
//    DuDH - Tạo mới Space
    @PostMapping (value = "/register")
    public ResponseEntity<Object> registerSpace (@RequestBody Spaces spaces){
        spaceService.saveNewSpace(spaces);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //    DuDH - Tìm kiếm theo ID Space
    @GetMapping (value = "/edit/{id}")
    public ResponseEntity<Spaces> findByID(@PathVariable Integer id){
        return new ResponseEntity<>(spaceService.findById(id), HttpStatus.OK);
    }
    //    DuDH - Chỉnh sửa Space
    @PatchMapping (value = "/edit/{id}")
    public ResponseEntity<Object> editSpace(@RequestBody Spaces spaces){
        spaceService.editSpace(spaces);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
