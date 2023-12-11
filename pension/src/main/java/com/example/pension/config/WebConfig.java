//package com.example.pension.config;
//
//import com.example.pension.interceptor.SessionCheckInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        // 모든 페이지 안보이게 함
//        registry.addInterceptor(new SessionCheckInterceptor())
//                .order(1).addPathPatterns("/**") // /+ 모두 차단
//                .excludePathPatterns("/login") // 로그인창은 허용
//                // .excludePathPatterns("/board/**"); // /board/ + 는 접속 허용
//                .excludePathPatterns("/"); // index.html 접속 허용
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        / : resources, ** : 모두
//        registry.addResourceHandler("/**")
//                .addResourceLocations("file:src/main/resources/static/upload/")
//                .addResourceLocations("file:///D:/temp/");
//        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css");
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js");
//    }
//}
