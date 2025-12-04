package com.ShopSphere.shop_sphere.security;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
 
//@Configuration
//public class SecurityConfig {
// 
//    @Bean
//    public FilterRegistrationBean<JwtAuthenticationFilter> 
//    jwtFilter(JwtAuthenticationFilter filter) {
//        FilterRegistrationBean<JwtAuthenticationFilter> reg = new FilterRegistrationBean<>();
//        reg.setFilter(filter);
//        reg.addUrlPatterns("/api/*");
//        reg.setOrder(1);
//        return reg;
//    }

 

@Configuration
public class SecurityConfig {

    // Register your JwtAuthenticationFilter bean
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil) {
        return new JwtAuthenticationFilter(jwtTokenUtil);
    }

    // Register filter for URLs starting with /api/*
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter(JwtAuthenticationFilter filter) {
        FilterRegistrationBean<JwtAuthenticationFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(filter);
        reg.addUrlPatterns("/api/*");   // Filter all API endpoints
        reg.setOrder(1);                // Run first
        return reg;
    }
}

 