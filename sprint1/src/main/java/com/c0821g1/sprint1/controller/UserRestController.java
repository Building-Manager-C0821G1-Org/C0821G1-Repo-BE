package com.c0821g1.sprint1.controller;

//import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.c0821g1.sprint1.dto.UserDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
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


    /**
     * created DuongNT
     * method updatePassword
     * @param userDTO
     * @return
     */

    @PutMapping("/changePassword")
    public ResponseEntity<AppUser> passwordUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("controller" + userDTO);
        AppUser appUser= userServiceImpl.changePassword(userDTO);
//        appUser = userServiceImpl.findById(userDTO.getId());
//        appUser.setPassword(userDTO.getNewPassword());
//        System.out.println(appUser.toString());

//        userServiceImpl.save(appUser);

        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<AppUser> getById(@PathVariable Integer id) {
       AppUser appUser= userServiceImpl.findById(id);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( appUser ,HttpStatus.OK);
    }

//    @PatchMapping("/student/update2")
//    public ResponseEntity<Student> updateCustomer2( @RequestBody Student student) {
//        iStudentService.save(student);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }

}

