package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    @Query(value = "select * from app_user " +
            "where app_user_name= ?1", nativeQuery = true)
    AppUser findAppUserByEmail(String appUserName);
}
