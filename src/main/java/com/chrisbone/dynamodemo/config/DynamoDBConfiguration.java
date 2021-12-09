package com.chrisbone.dynamodemo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {
    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(buildDynamoDBObject());
    }

    private AmazonDynamoDB buildDynamoDBObject() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        "db link",
                        "region"
                ))
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "",
                                        ""
                                )
                        )
                ).build();
    }

}
