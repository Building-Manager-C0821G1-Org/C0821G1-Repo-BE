package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/spaces")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;

    @GetMapping("/list")
    public ResponseEntity<Page<Spaces>> findAllSpace(@PageableDefault(size = 4) Pageable pageable) {
        Page<Spaces> spacesList = spaceService.findAllSpace(pageable);
        if (spacesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(spacesList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public void deleteSpaceById(@PathVariable Integer id) {
        spaceService.deleteById(id);
    }

    @GetMapping("/search")
    public Page<Spaces> searchSpace(@RequestParam(value = "floorName",defaultValue = "") String floorName,
                                    @RequestParam(value = "spaceCode", defaultValue = "") String spaceCode,
                                    @RequestParam(value = "spaceArea", defaultValue = "") String spaceArea,
                                    @RequestParam(value = "spaceTypeName",defaultValue = "") String spaceTypeName,
                                    @RequestParam(value = "spaceStatusName",defaultValue = "") String spaceStatusName,
                                    @PageableDefault(value = 4) Pageable pageable) {
        return spaceService.searchSpace(floorName, spaceCode, spaceArea, spaceTypeName, spaceStatusName, pageable);
    }
}
