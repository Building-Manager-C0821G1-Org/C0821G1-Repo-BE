package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.c0821g1.sprint1.dto.UserDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.user.User;
import com.c0821g1.sprint1.service.UserService;
import com.c0821g1.sprint1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    UserServiceImpl userServiceImpl;

//    @PostMapping(path = "/changePassword")
//    public ResponseEntity<User> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
//        int targetUserId = changePasswordDTO.getTargetUserId();
//        System.out.println(targetUserId);
//        boolean check = userServiceImpl.changePassword(targetUserId, changePasswordDTO);
//        System.out.println(check);
//        return new ResponseEntity(check, HttpStatus.OK);
//    }

    @PutMapping("/changePassword")
    public ResponseEntity<User> passwordUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user;
        user = userServiceImpl.findById(userDTO.getId());
        user.setPassword(userDTO.getNewPassword());
        System.out.println(user);
        userServiceImpl.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
       User user= userServiceImpl.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( user ,HttpStatus.OK);
    }

//    @PatchMapping("/student/update2")
//    public ResponseEntity<Student> updateCustomer2( @RequestBody Student student) {
//        iStudentService.save(student);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }

}

