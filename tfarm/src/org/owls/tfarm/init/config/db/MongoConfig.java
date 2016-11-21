package org.owls.tfarm.init.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	private final String MONGO_URL = "127.0.0.1";
	private final Integer MONGO_PORT = 27017;

	@Override
	protected String getDatabaseName() {
		return "tfarm";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(MONGO_URL, MONGO_PORT);
	}
}