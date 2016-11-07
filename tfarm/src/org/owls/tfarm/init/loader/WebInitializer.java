package org.owls.tfarm.init.loader;

//import javax.servlet.Registration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.owls.tfarm.init.config.db.MongoConfig;
import org.owls.tfarm.init.config.server.ServerConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init onStratup");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ServerConfig.class);
		ctx.register(MongoConfig.class);
		
		//Read log4j Settings
		//http://stackoverflow.com/questions/32713596/spring-application-without-web-xml-log4j-configuration
		arg0.setInitParameter("log4jConfiguration", "/WEB-INF/config/log4j.properties");
		
		//Register system user if Mongo does not have user collection
		
		
		//Servlet #1
		ctx.setServletContext(arg0);
		Dynamic dispatcher = arg0.addServlet("dispatcher", new DispatcherServlet(ctx));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
		System.out.println("Common web service is ready");
		
		//Servlet #2 Admin
//		Dynamic adminDispatcher = arg0.addServlet("adminDispatcher", new DispatcherServlet(ctx));
//		adminDispatcher.addMapping("/admin");
//		adminDispatcher.setLoadOnStartup(2);
//		System.out.println("Admin web service is ready");
	}
};