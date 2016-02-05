package com.devarchi33.config;

import com.devarchi33.aws.service.EC2GetStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donghoon on 2016. 2. 2..
 */
@Configuration
public class UtilConfig {

    @Bean(name = "EC2GetStatus")
    public EC2GetStatus getEC2GetStatus() {
        return new EC2GetStatus();
    }
}
