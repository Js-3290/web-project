package com.js.config;

import com.js.interceptor.DemoInterceptor;
import com.js.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器, 拦截所有请求
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")//添加拦截项
                .excludePathPatterns("/login");//添加排除项

    }
}
