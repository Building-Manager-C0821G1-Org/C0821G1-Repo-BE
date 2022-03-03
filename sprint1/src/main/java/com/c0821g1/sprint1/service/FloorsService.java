package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.floors.Floors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface FloorsService {
    Page<Floors> findAllFloors(Pageable pageable);

    Optional<Floors> findFloorsById(Integer id);

    void deleteFloorsById(Integer id);


    void editFloors(Floors floors);

    Floors findById(Integer id);
}
