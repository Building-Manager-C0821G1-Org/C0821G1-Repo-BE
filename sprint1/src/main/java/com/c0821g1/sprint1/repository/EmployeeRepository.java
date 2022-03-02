package com.c0821g1.sprint1.repository;


import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * from employee e join app_users a on e.app_user_id = a.id where a.username =?1", nativeQuery = true)
    Employee findEmployeeByAppUser(String username);
}
