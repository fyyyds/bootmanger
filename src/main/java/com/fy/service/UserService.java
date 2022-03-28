package com.fy.service;

import com.fy.pojo.User;

/**
 * @author: fy
 * @create: 2022-03-24 15:33
 **/
public interface UserService {
    User getUser(String userCode, String password);
}
