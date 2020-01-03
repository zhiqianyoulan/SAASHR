package com.cy.pj.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cy.pj.common.web.TimeAccessInterceptor;
@Configuration
public class SpringWebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册拦截器，并设置拦截路径
		registry.addInterceptor(new TimeAccessInterceptor()).addPathPatterns("/user/doLogin");
	}
}
