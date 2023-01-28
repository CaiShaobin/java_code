package com.abin.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("进入拦截器...");
        HttpSession session = request.getSession();

        String username = ((String) session.getAttribute("username"));
        if (username == null){
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
