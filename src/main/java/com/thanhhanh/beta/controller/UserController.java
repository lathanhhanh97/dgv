package com.thanhhanh.beta.controller;

import com.thanhhanh.beta.entity.User;
import com.thanhhanh.beta.model.UserNameProfile;
import com.thanhhanh.beta.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@Api(value = "Api user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Lấy thông tin user bằng user_id")
    @GetMapping("/{user_id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer user_id){
        return ResponseEntity.ok(userService.getUserById(user_id));
    }

    @ApiOperation(value = "Đăng ký user")
    @GetMapping("/register")
    public ResponseEntity<?> registerUser(){
        return null;
    }

    @ApiOperation(value = "Cập nhật user")
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @Valid @RequestBody UserNameProfile user) throws ParseException {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
