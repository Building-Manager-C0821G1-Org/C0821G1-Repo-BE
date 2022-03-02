package com.c0821g1.sprint1.repository.employee;


import com.c0821g1.sprint1.entity.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition,Integer> {
     List<EmployeePosition> findAll();
}
