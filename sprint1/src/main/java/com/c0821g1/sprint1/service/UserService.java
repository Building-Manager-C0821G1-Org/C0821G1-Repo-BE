package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.c0821g1.sprint1.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean changePassword(int id, ChangePasswordDTO changePasswordDTO);

}
