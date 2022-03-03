package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    @Query(value = "select * from app_user " +
            "where app_user_name= :username", nativeQuery = true)
    AppUser findAppUserByEmail(@Param("username") String app_user_name);
}
