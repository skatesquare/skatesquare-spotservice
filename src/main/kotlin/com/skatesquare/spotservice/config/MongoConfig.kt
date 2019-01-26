package com.skatesquare.spotservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["com.skatesquare.spotservice.repository"])
class MongoConfig