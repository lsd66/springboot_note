package com.lsd.springboot_learning.interceptor;

import com.lsd.springboot_learning.exception.BizException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object Handler) throws Exception{
        //核心业务逻辑，判断是否登录
        String token=request.getHeader("token");
        // 正常token是登录后签发的，前端携带过来
        // return StringUtils.hasLength(token); //之前是这个，之前没有返回
        if(!StringUtils.hasLength(token)){
            throw new BizException(9001,"token不能为空");
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //
        System.out.println("controller 执行完了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("我获取到了一个返回的结果："+response);
        System.out.println("请求结束了");
    }
}
