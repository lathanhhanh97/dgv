package com.thanhhanh.beta.model;

public class UserNameProfile {
    private int userId;
    private String username;
    private String userAvatar;
    private String userFullname;
    private String userBirthday;
    private int userGender;
    private String userEmail;
    private String userCity;
    private String userPhone;
    private int userPoint;

    public UserNameProfile() {
    }

    public UserNameProfile(int userId, String username, String userAvatar, String userFullname, String userBirthday, int userGender, String userEmail, String userCity, String userPhone, int userPoint) {
        this.userId = userId;
        this.username = username;
        this.userAvatar = userAvatar;
        this.userFullname = userFullname;
        this.userBirthday = userBirthday;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userCity = userCity;
        this.userPhone = userPhone;
        this.userPoint = userPoint;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }
}
