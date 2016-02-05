package com.devarchi33.config;

import com.amazonaws.services.ec2.AmazonEC2Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donghoon on 2016. 2. 2..
 */
@Configuration
@ComponentScan(basePackages = {"com.devarchi33"})
public class AwsConfig {

    @Bean(name = "AmazonEC2Client")
    public AmazonEC2Client getAmazonEC2Client() {
        return new AmazonEC2Client();
    }
}
