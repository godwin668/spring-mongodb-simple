package com.idocv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.idocv.repository" })
class ApplicationConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "spring-mongo";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("192.168.1.200", 27017);
	}

	@Override
  protected String getMappingBasePackage() {
		return "com.idocv";
  }
}