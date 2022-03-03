package com.c0821g1.sprint1.service;


import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpaceService {
    Page<Spaces> findAllSpace(Pageable pageable);

    void deleteById(Integer id);

    Page<Spaces> searchSpace(String floorName, String spaceCode, String spaceArea,
                             String spaceTypeName, String spaceStatusName, Pageable pageable);
}
