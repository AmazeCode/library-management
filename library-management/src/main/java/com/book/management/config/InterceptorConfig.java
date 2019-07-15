package com.book.management.config;

import com.book.management.interceptor.AuthInterceptor;
import com.book.management.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 注册过滤器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 自定义过滤器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录过滤器
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**");// 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        //添加权限过滤器
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 登录过滤器
     * @return
     */
   @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    /**
     * 权限过滤器
     * @return
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Value(value = "${upload.file.path}")
    private String uploadFilePath;

    /**
     * 添加资源过滤请求
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadFilePath);
    }

    /**
     * 跨域支持
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    /**
     * 自定义跳转首页
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry ) {
        //跳转登录页面
        registry.addViewController( "/" ).setViewName( "redirect:login.jsp" );
    }
}
