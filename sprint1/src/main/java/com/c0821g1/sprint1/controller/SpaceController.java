package com.c0821g1.sprint1.controller;
import com.c0821g1.sprint1.dto.space.SpacesDTO;
import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.service.SpaceService;
import com.c0821g1.sprint1.service.SpaceStatusService;
import com.c0821g1.sprint1.service.SpaceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
    @PostMapping (value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerSpace (@RequestBody @Valid SpacesDTO spacesDTO, BindingResult bindingResult){
        if(spaceService.existsSpaceByCode(spacesDTO.getSpaceCode())){
            bindingResult.rejectValue("spaceCode", "Mã mặt bằng đã tồn tại.");
        }
//        if(spacesDTO.getSpaceArea().contains("-")){
//            bindingResult.rejectValue("spaceArea", "Diện tích không được nhập số âm.");
//        }

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Spaces spacesObj = new Spaces();
        BeanUtils.copyProperties(spacesDTO, spacesObj);
        spaceService.saveNewSpace(spacesObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //    DuDH - Tìm kiếm theo ID Space
    @GetMapping (value = "/{id}")
    public ResponseEntity<Spaces> findByID(@PathVariable Integer id){
        return new ResponseEntity<>(spaceService.findById(id), HttpStatus.OK);
    }
    //    DuDH - Chỉnh sửa Space
    @PatchMapping (value = "/edit/{id}")
    public ResponseEntity<Object> editSpace(@RequestBody @Valid SpacesDTO spacesDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Spaces spacesObj = new Spaces();
        BeanUtils.copyProperties(spacesDTO, spacesObj);
        spaceService.editSpace(spacesObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
