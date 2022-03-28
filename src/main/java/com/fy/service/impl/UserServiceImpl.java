package com.fy.service.impl;

import com.fy.dao.UserDao;
import com.fy.pojo.User;
import com.fy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: fy
 * @create: 2022-03-24 15:34
 **/
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userCode, String password) {
        User user = userDao.getUser(userCode, password);
        System.out.println("aaaaaaaaaaaaaaaaaaaaa"+user);
        return user;
    }
}
