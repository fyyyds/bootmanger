package com.fy.controller;

import com.fy.pojo.User;
import com.fy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: fy
 * @create: 2022-03-24 15:37
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param usercode
     * @param password
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/login")
    public String login(String usercode, String password, HttpSession session, Model model) {
        User user = userService.getUser(usercode, password);
        System.out.println("aaaaaaaaaaaaa"+user);
        if (user != null) {
            session.setAttribute("USER_SESSION", user);
            return "customer";
        }
        model.addAttribute("msg","账号或者密码错误，请重新输入！");
        return "login";
    }

    /**
     * 跳转到客户管理页面的方法
     * @return
     */
    @RequestMapping(value = "/toCustomer")
    public String toCustomer() {
        return "customer";
    }

    /**
     *退出登录
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 清除session
        session.invalidate();
        // 重定向到登录页面
        return "login";
    }

    /**
     *向用户登录页面跳转
     * @return
     */
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }
}
