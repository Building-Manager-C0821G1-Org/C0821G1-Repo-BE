package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.floor.Floors;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface FloorsService {
    List<Floors> findAll();

    Optional<Floors> findFloorsById(Integer id);

    void deleteFloorsById(Integer id);


}
