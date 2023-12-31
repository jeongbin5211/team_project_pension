package com.example.pension.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String reqURI = request.getRequestURI();
        HttpSession hs = request.getSession();

        if(hs.getAttribute("user") == null) {
            System.out.println("You are not Incorrectly");
            if(hs.getAttribute("admin") != null) {
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
