package com.thanhhanh.beta.service;

import com.thanhhanh.beta.entity.User;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseData<User> getUserById(Integer user_id){
        if(userRepository.getUserById(user_id) == null){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);


        }else{
            return new ResponseData(HttpStatus.OK, "success", userRepository.getUserById(user_id));
        }
    }
}
