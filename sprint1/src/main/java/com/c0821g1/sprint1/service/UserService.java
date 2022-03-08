package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.c0821g1.sprint1.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean changePassword(int id, ChangePasswordDTO changePasswordDTO);

    User findById(Integer id);

    void save(User user);

    List<User> findAll();
}
