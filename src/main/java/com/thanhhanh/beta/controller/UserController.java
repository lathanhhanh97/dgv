package com.thanhhanh.beta.controller;

import com.thanhhanh.beta.entity.User;
import com.thanhhanh.beta.model.UserNameProfile;
import com.thanhhanh.beta.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;

@RestController
@Api(value = "Api user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Đăng ký user")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @ApiOperation(value = "Cập nhật user")
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(Authentication authentication, @Valid @RequestBody UserNameProfile user) throws ParseException {
        return ResponseEntity.ok(userService.updateUser(authentication, user));
    }

    @ApiOperation(value = "Đăng nhập - Get token login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody HashMap<String, String> request){
        return ResponseEntity.ok(userService.loginUser(request.get("username"), request.get("password")));
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo(Authentication authentication){
        return ResponseEntity.ok(userService.getInfo(authentication));
    }
}
