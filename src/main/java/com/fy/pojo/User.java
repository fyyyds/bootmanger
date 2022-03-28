package com.fy.pojo;

/**
 * @author: fy
 * @create: 2022-03-24 15:15
 **/
public class User {
    private Integer userId; //用户id
    private String userCode;// 用户编号
    private String username;//用户名
    private String password;//密码
    private Integer status;//用户状态

    public User(Integer userId, String userCode, String username, String password, Integer status) {
        this.userId = userId;
        this.userCode = userCode;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userCode='" + userCode + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
