package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.floors.Floors;
import com.c0821g1.sprint1.repository.FloorsRepository;
import com.c0821g1.sprint1.service.FloorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FloorServiceImpl implements FloorsService {
    @Autowired
    FloorsRepository floorsRepository;

    @Override
    public Page<Floors> findAllFloors(Pageable pageable) {

        return this.floorsRepository.findAll(pageable);
    }

    @Override
    public Optional<Floors> findFloorsById(Integer id) {
        return this.floorsRepository.findById(id);
    }

    @Override
    public void deleteFloorsById(Integer id) {
        this.floorsRepository.deleteById(id);
    }

    @Override
    public void editFloors(Floors floors) {
        this.floorsRepository.save(floors);
    }

    @Override
    public Floors findById(Integer id) {
        return this.floorsRepository.findById(id).orElse(null);
    }
}
