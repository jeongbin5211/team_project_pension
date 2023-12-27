package com.example.pension.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession hs = request.getSession();
        String reqURI = request.getRequestURI();

        if(hs.getAttribute("admin") == null) {
            System.out.println("You are not Incorrectly");
            if(hs.getAttribute("user") != null) {
                response.sendRedirect("/");
                return false;
            }else {
                response.sendRedirect("/login?redirectURI=" + reqURI);
                return false;
            }
        }

        return true;
    }
}
