package com.c0821g1.sprint1.repository.account;
import com.c0821g1.sprint1.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

    // NghiaDM tìm kiếm app use theo usename
    @Query(value = "SELECT * FROM app_users WHERE username= :username", nativeQuery = true)
    AppUser getAppUserByUsername(@Param("username") String username);

}