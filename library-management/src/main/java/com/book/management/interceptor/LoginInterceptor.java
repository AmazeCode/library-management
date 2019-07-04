package com.book.management.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.book.management.annotation.LoginRequired;
import com.book.management.annotation.UserLoginToken;
import com.book.management.model.User;
import com.book.management.service.UserService;
import com.book.management.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查有没有需要用户登录的注解
        User currentUser = (User) httpServletRequest.getSession().getAttribute("user");
        if (method.isAnnotationPresent(LoginRequired.class)) {
            //拿到登录需要注解
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            if (loginRequired.required()) {
                if (currentUser == null) {
                    httpServletResponse.sendRedirect("/book/login.jsp");
                    return false;
                }
            }
        }
        //检查有没有需要用户token的注解
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            //登录Token
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("token为空,请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("无权限访问");
                }
                User user = userService.findUserByUserId(Long.parseLong(userId));
                if (user == null) {
                    throw new RuntimeException("用户不存在,请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JwtUtil.SECRET)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("token失效,无权限访问");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
