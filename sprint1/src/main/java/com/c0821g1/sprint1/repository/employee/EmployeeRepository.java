package com.c0821g1.sprint1.repository.employee;


import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from  employee where employee_delete_flag = false ", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);

    @Query(value = "select * from employee where employee_name like concat('%',:employee_name,'%') " +
            "and employee_date_of_birth like concat('%',:employee_date_of_birth,'%') and employee_email like concat('%',:employee_email,'%')" +
            " and employee_address like concat('%',:employee_address,'%') and employee_delete_flag = false", nativeQuery = true)
    Page<Employee> searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(Pageable pageable, @Param("employee_name") String employee_name
            , @Param("employee_date_of_birth") String employee_date_of_birth, @Param("employee_email") String employee_email, @Param("employee_address") String employee_address);

    @Transactional
    @Modifying
    @Query(value = "update employee  set employee_delete_flag = 1 where employee_id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Integer id);
}
