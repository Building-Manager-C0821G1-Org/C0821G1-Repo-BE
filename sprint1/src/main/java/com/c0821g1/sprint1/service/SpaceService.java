package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.stereotype.Service;

@Service
public interface SpaceService {
    void saveNewSpace(Spaces spaces);

    Spaces findById(Integer id);

    void save(Spaces spaces);

    void editSpace(Spaces spaces);

    boolean existsSpaceByCode(String spaceCode);

}
