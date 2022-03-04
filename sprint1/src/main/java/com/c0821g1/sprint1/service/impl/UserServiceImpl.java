package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.c0821g1.sprint1.entity.user.User;
import com.c0821g1.sprint1.repository.UserRepository;
import com.c0821g1.sprint1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean changePassword(int id, ChangePasswordDTO changePasswordDTO) {
        User user = userRepository.findById(id);
        String currentPassword = user.getPassword();
        String targetPassword = changePasswordDTO.getCurrentPassword();
        String newPassword = changePasswordDTO.getNewPassword();
        String confirmPassword = changePasswordDTO.getConfirmPassword();
        System.out.println(user);
        boolean compareCurrentPassword = compareCurrentPassword(currentPassword, targetPassword);
        boolean compareNewPasswordAndConfirmPassword = compareNewPasswordAndConfirmPassword(newPassword, confirmPassword);
        if (!compareCurrentPassword) {
            return false;
        }

        if (!compareNewPasswordAndConfirmPassword) {
            return false;
        }
        return true;
    }

    private static boolean compareCurrentPassword(String currentPass, String targetPass) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String pw = bCryptPasswordEncoder.encode(targetPass);
        System.out.println(pw);
        if (currentPass.equals(pw)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean compareNewPasswordAndConfirmPassword(String newPassword, String confirmPassword) {
        if(newPassword.equals(confirmPassword) ){
            return false;
        }
        return true;

    }
}
