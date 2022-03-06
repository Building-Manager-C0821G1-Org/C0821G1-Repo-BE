package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.repository.SpaceRepository;
import com.c0821g1.sprint1.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpaceServiceImpl implements SpaceService {
    @Autowired
    private SpaceRepository spaceRepository;


    @Override
    public List<SpaceListDTO> findAllSpace() {
        return this.spaceRepository.findAllSpace();
    }

    @Override
    public void deleteById(Integer id) {
        spaceRepository.deleteSpaceById(id);
    }

    @Override
    public Page<Spaces> searchSpace(String floorName, String spaceCode, String spaceArea, String spaceTypeName, String spaceStatusName, Pageable pageable) {
        return spaceRepository.searchSpace(floorName, spaceCode, spaceArea, spaceTypeName, spaceStatusName, pageable);
    }


}
