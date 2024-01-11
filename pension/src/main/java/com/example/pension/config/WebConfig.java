package com.example.pension.config;

import com.example.pension.interceptor.AdminCheckInterceptor;
import com.example.pension.interceptor.SessionCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 모든 페이지 안보이게 함
        registry.addInterceptor(new SessionCheckInterceptor())
                .order(1)
                .addPathPatterns("/reserve/reserveCheck")
                .addPathPatterns("/reserve/requestRoom")
                .addPathPatterns("/mypage/**")
                .excludePathPatterns("/login") // 로그인창은 허용
                .excludePathPatterns("/");
//
        registry.addInterceptor(new AdminCheckInterceptor())
                .order(1)
                .addPathPatterns("/admin/**");
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        / : resources, ** : 모두
        registry.addResourceHandler("/**")
                .addResourceLocations("file:src/main/resources/static/roomImages/", "file:src/main/resources/static/noticeImages/", "file:src/main/resources");
//                .addResourceLocations("file:///D:/temp/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js");
    }
}
