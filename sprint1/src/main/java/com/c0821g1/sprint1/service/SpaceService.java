package com.c0821g1.sprint1.service;


import com.c0821g1.sprint1.dto.SpaceListDTO;

import java.util.List;

public interface SpaceService {
    List<SpaceListDTO> findAllSpace();

    void deleteById(Integer id);

    List<SpaceListDTO> searchSpace(String floorName, String spaceCode, String spaceArea, String spaceTypeName, String spaceStatusName);

    SpaceListDTO findSpaceById(Integer spaceId);
}
