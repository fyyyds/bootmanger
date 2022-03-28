package com.fy.interceptor;

import com.fy.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: fy
 * @create: 2022-03-24 15:32
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求的url
        String url = request.getRequestURI();
        // 访问登录页面的url不应该拦截（形式是****/login），其它的url请求全部拦截
        if (url.contains("/login")){
            return true;
        }

        // 获取session
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("USER_SESSION");
        // user == null 表示没有登录  user!= null 表示已经登录，返回true，放行。
        if (user != null) {
            return true;
        }

        // 执行到以下代码表示user == null ，用户没有登录,给出提示信息，转发到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
