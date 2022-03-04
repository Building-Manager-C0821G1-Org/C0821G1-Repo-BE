package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.user.User;
import com.c0821g1.sprint1.service.UserService;
import com.c0821g1.sprint1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping(path = "/changePassword")
    public ResponseEntity<User> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        int targetUserId = changePasswordDTO.getTargetUserId();
        System.out.println(targetUserId);
        boolean check = userServiceImpl.changePassword(targetUserId, changePasswordDTO);
        System.out.println(check);
        return new ResponseEntity(check, HttpStatus.OK);
    }


}

