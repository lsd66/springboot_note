package com.lsd.springboot_learning.config;

import com.lsd.springboot_learning.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 *如果我们的项目中有关于跨域的处理，同时还有拦截器，然后还要使用swagger，
 * 这种情况大家要注意了，
 * 有可能我们的拦截器会将swagger中的页面路径拦截掉导致swagger页面出不来，
 * 当我们在拦截器中把swagger的页面排除掉的时候，也有可能会导致跨域配置的失效。
 * InterceptorConfig和CorsConfig文件夹
 */

@Configuration
public class InterceptorConfig extends WebMvcConfig {
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(tokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/downloadExcel")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
