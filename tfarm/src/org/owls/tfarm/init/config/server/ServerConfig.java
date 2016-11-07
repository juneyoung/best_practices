package org.owls.tfarm.init.config.server;

import org.owls.tfarm.init.config.interceptor.InformationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@ComponentScan(basePackages={
		"org.owls.tfarm.init.*"
		, "org.owls.tfarm.api.*"
		, "org.owls.tfarm.member.*"
		, "org.owls.tfarm.common.*"
		, "org.owls.tfarm.webservice.*"
		}
, excludeFilters=@ComponentScan.Filter(Configuration.class))
//JJD 한테 ComponentScan 어떻게 걸었는지 물어보기
//Filter 걸 때 Configuration.class 를 수동으로 등록해줘야 되는데 나은 방법 찾아보기 
public class ServerConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver(){
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		System.out.println("returning ViewResolver");
		System.out.println(irvr);
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
};