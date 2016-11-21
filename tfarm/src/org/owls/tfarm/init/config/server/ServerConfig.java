package org.owls.tfarm.init.config.server;

import java.util.List;

import org.owls.tfarm.init.config.interceptor.InformationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@EnableAsync	//for what?
// @ComponentScan can cover only 4depth + *
@ComponentScan(basePackages={
		"org.owls.tfarm.init.*"
		, "org.owls.tfarm.api.*"
		, "org.owls.tfarm.member.*"
		, "org.owls.tfarm.service.*"
		, "org.owls.tfarm.common.*"
		}
, excludeFilters=@ComponentScan.Filter(Configuration.class))
//Filter 걸 때 Configuration.class 를 수동으로 등록해줘야 되는데 나은 방법 찾아보기 
public class ServerConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver(){
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	//Welcome file 대체 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	//Catch And Print
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InformationInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//http://www.baeldung.com/spring-httpmessageconverter-rest
		//converters.add(jsonConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	
	// 어차피 한개인데 왜 빈으로 만드나 
//	@Bean
//	public MappingJackson2HttpMessageConverter jsonConverter(){
//		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//		return jsonConverter;
//	}
};