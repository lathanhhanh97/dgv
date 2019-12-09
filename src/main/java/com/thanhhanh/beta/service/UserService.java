package com.thanhhanh.beta.service;

import com.thanhhanh.beta.config.JwtToken;
import com.thanhhanh.beta.entity.User;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.model.UserNameProfile;
import com.thanhhanh.beta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken token;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseData<String> updateUser(Authentication authentication, UserNameProfile user){
        Integer userId = userRepository.findIdByUsername(authentication.getName());
        Integer rs = userRepository.updateUser(user.getUsername(), user.getUserFullname(), user.getUserBirthday(), user.getUserGender(), user.getUserEmail(), user.getUserCity(), user.getUserPhone(), userId);
        return new ResponseData(HttpStatus.OK, "success", rs);
    }

    public ResponseData<Integer> registerUser(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return new ResponseData(HttpStatus.OK, "username exist", 0);
        }
        if(userRepository.findByEmail(user.getUserEmail()) != null){
            return new ResponseData(HttpStatus.OK, "email exist", 0);
        }
        if(userRepository.findByPhone(user.getUserPhone()) != null){
            return new ResponseData(HttpStatus.OK, "phone exist", 0);
        }

        String avt;
        if(user.getUserGender() == 1){
            avt = "http://lathanhhanh.tk/src/beta/img/trai.jpg";
        }else{
            avt = "http://lathanhhanh.tk/src/beta/img/gai.jpg";
        }
        return new ResponseData(HttpStatus.OK, "success", userRepository.registerUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), avt, user.getUserFullname(), user.getUserBirthday(), user.getUserGender(), user.getUserEmail(), user.getUserCity(), user.getUserPhone()));
    }

    public ResponseData<String> loginUser(String username, String password){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username, password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = token.generateToken((UserDetails) authentication.getPrincipal());
        return new ResponseData(HttpStatus.OK, "success", jwt);
    }

    public ResponseData<User> getInfo(Authentication authentication){
        return new ResponseData(HttpStatus.OK, "success", userRepository.findByUsername(authentication.getName()));
    }
}
