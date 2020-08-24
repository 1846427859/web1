package com.lyc.config;

import com.lyc.intercepter.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@ComponentScan(value = {"com.lyc.controller"})
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();
    }

    /**
     * 静态资源访问
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
