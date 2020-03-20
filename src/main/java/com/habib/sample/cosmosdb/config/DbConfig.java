package com.habib.sample.cosmosdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import com.mongodb.client.MongoClients;



@Configuration
public class DbConfig {
@Value("${spring.data.mongodb.uri}")
private String mongoUri;	
PropertyConfig propertyConfig;
@Autowired
public void setPropertyConfig(PropertyConfig propertyConfig) {
	this.propertyConfig = propertyConfig;
}

	@Bean
    public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoClientDbFactory(MongoClients.create(mongoUri), propertyConfig.getDbname());
    }

	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

    }
}

