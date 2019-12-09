package com.thanhhanh.beta.repository;

import com.thanhhanh.beta.entity.User;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.model.UserNameProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //SELECT * FROM `users` WHERE `user_id` = user_id
    // lấy thông tin user bằng id
    @Query(name = "getUserNameProfile", nativeQuery = true)
    UserNameProfile getUserById(Integer user_id);
    //Thêm user vào dữ liệu ;
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `users`( `username`, `password`, `user_avatar`, `user_fullname`, `user_birthday`, `user_gender`, `user_email`, `user_city`, `user_phone`, `user_point`) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,0)", nativeQuery = true)
    Integer registerUser(String username, String password, String user_avatar,String user_fullname,  String user_birthday, Integer user_gender, String user_email, String user_city, String user_phone);
    //update
    @Transactional
    @Modifying
    @Query(value = "UPDATE `users` SET ,`username`= ?1, `user_fullname`=?2,`user_birthday`=?3,`user_gender`=?4,`user_email`=?5,`user_city`=?6,`user_phone`=?7 WHERE `user_id`= ?8", nativeQuery = true)
    Integer updateUser(String username, String user_fullname, String user_birtday, Integer user_gender, String user_email, String user_city, String user_phone, Integer user_id);

    User findByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM `users` WHERE `user_email` = ?1")
    User findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM `users` WHERE `user_phone` = ?1")
    User findByPhone(String email);

    @Query(nativeQuery = true, value = "SELECT `user_id` FROM `users` WHERE `username` = ?1")
    Integer findIdByUsername(String username);
}
