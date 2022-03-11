package com.c0821g1.sprint1.service;


import com.c0821g1.sprint1.entity.space.SpacesStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpaceStatusService {
    List<SpacesStatus> getAllSpacesStatus();
}
