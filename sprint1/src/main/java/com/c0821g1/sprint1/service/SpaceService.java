package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.stereotype.Service;
import com.c0821g1.sprint1.dto.SpaceListDTO;
import java.util.List;

public interface SpaceService {
    List<SpaceListDTO> findAllSpace();

    void deleteById(Integer id);

    List<SpaceListDTO> searchSpace(String floorName, String spaceCode, String spaceArea, String spaceTypeName, String spaceStatusName);

    SpaceListDTO findSpaceById(Integer spaceId);

    void saveNewSpace(Spaces spaces);

    Spaces findById(Integer id);

    void save(Spaces spaces);

    void editSpace(Spaces spaces);

    boolean existsSpaceByCode(String spaceCode);
}
