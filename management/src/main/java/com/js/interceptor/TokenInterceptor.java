package com.js.interceptor;

import com.js.utils.CurrentHolder;
import com.js.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        //1.获取请求路径
//        String requestURI = request.getRequestURI();
//
//        //2.判断是否是登录请求，如果路径中包含/login，则放行
//        if(requestURI.contains("/login")){
//            log.info("登录请求，放行");
//            return true;
//        }


        //3.获取请求头中的token
        String token = request.getHeader("token");

        //4.判断token是否为空，如果为空，则提示用户登录，返回状态码401
        if(token == null || token.isEmpty()){
            log.info("token为空，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //5.判断token是否正确，检验令牌，如果不正确，则提示用户登录，返回状态码401
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer id = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(id);
            log.info("当前用户id：{}", id);

        } catch (Exception e) {
            log.info("令牌错误，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //6.放行
        log.info("令牌正确，放行");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //移除当前用户
        CurrentHolder.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
