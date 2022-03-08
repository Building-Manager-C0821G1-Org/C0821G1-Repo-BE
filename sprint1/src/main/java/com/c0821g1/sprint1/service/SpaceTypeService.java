package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.space.SpacesType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpaceTypeService {
    List<SpacesType> getAllSpacesType();
}
