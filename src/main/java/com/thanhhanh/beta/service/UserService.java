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
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken token;

    public ResponseData<UserNameProfile> getUserById(Integer user_id){
        if(userRepository.getUserById(user_id) == null){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "success", userRepository.getUserById(user_id));
        }
    }

    public ResponseData<String> updateUser(Integer user_id, UserNameProfile user) throws ParseException {
        UserNameProfile u = userRepository.getUserById(user_id);
        u.setUsername(user.getUsername());
        u.setUserFullname(user.getUserFullname());

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
        Date date = dt.parse(user.getUserBirthday());

        u.setUserBirthday(dt.format(date));
        u.setUserGender(user.getUserGender());
        u.setUserEmail(user.getUserEmail());
        u.setUserCity(user.getUserCity());
        u.setUserPhone(user.getUserPhone());

        userRepository.updateUser(user.getUsername(), user.getUserFullname(),dt.format(date), user.getUserGender(), user.getUserEmail(), user.getUserCity(),user.getUserPhone(), user_id);

        return new ResponseData(HttpStatus.OK, "success", userRepository.updateUser(user.getUsername(), user.getUserFullname(),dt.format(date), user.getUserGender(), user.getUserEmail(), user.getUserCity(),user.getUserPhone(), user_id));
    }

    public ResponseData<Integer> registerUser(User user){
        if(userRepository.findByUsername(user.getUsername()) == null){
            String avt;
            if(user.getUserGender() == 1){
                avt = "http://lathanhhanh.tk/src/beta/img/trai.jpg";
            }else{
                avt = "http://lathanhhanh.tk/src/beta/img/gai.jpg";
            }
            return new ResponseData(HttpStatus.OK, "success", userRepository.registerUser(user.getUsername(), user.getPassword(), avt, user.getUserFullname(), user.getUserBirthday(), user.getUserGender(), user.getUserEmail(), user.getUserCity(), user.getUserPhone()));
        }else{
            return new ResponseData(HttpStatus.OK, "username exits", 0);
        }
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
}
