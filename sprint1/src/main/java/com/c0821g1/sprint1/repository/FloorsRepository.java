package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.floors.Floors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorsRepository extends JpaRepository<Floors,Integer> {
}
