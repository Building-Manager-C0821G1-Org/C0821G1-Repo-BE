package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.repository.FloorsRepository;
import com.c0821g1.sprint1.service.FloorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorServiceImpl implements FloorsService {
    @Autowired
    FloorsRepository floorsRepository;

    @Override
    public List<Floors> findAll() {
        return floorsRepository.findAll();
    }

    @Override
    public Optional<Floors> findFloorsById(Integer id) {
        return floorsRepository.findById(id);
    }

    @Override
    public void deleteFloorsById(Integer id) {
        floorsRepository.deleteById(id);
    }
}
