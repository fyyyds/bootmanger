package com.fy.dao;

import com.fy.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author: fy
 * @create: 2022-03-24 15:19
 **/
public interface UserDao {

    /**
     * 通过账号和密码查询用户
     * @param userCode
     * @param password
     * @return
     */
    User getUser(@Param("userCode") String userCode, @Param("password") String password);
}
