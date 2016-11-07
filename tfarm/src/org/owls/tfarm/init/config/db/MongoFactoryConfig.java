package org.owls.tfarm.init.config.db;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoFactoryConfig {

	//Annotation @Bean의 위치가 return Value 에 있는 것과 method 위에 있는 것과의 차이 
	public @Bean MongoDbFactory mongoFactory() throws UnknownHostException{
		return new SimpleMongoDbFactory(new MongoClient(), "tfarm");
	}
	
	public @Bean MongoTemplate mongoTemplate() throws UnknownHostException{
		MongoTemplate mongoTemplate = new MongoTemplate(mongoFactory());
		return mongoTemplate;
	}
};