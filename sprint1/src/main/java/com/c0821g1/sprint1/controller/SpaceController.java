package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/spaces")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;

    @GetMapping("/list")
    public ResponseEntity<Page<SpaceListDTO>> findAllSpace(Pageable pageable) {
        List<SpaceListDTO> spaceListDTOS = spaceService.findAllSpace();
        Page<SpaceListDTO> pages = new PageImpl<>(spaceListDTOS, pageable, spaceListDTOS.size());
        if (pages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public void deleteSpaceById(@PathVariable Integer id) {
        spaceService.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<SpaceListDTO>> searchSpace(@RequestParam(value = "floorName", defaultValue = "") String floorName,
                                    @RequestParam(value = "spaceCode", defaultValue = "") String spaceCode,
                                    @RequestParam(value = "spaceArea", defaultValue = "") String spaceArea,
                                    @RequestParam(value = "spaceTypeName", defaultValue = "") String spaceTypeName,
                                    @RequestParam(value = "spaceStatusName", defaultValue = "") String spaceStatusName, Pageable pageable) {
        List<SpaceListDTO> spaceListDTOS = spaceService.searchSpace(floorName,spaceCode,spaceArea,spaceTypeName,spaceStatusName);
        Page<SpaceListDTO> pages = new PageImpl<>(spaceListDTOS, pageable, spaceListDTOS.size());
        if (pages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SpaceListDTO> findSpaceById(@PathVariable("id") Integer id) {
        SpaceListDTO spaceListDTO = spaceService.findSpaceById(id);
        if (spaceListDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(spaceListDTO, HttpStatus.OK);
    }
}
