package com.devarchi33.aws.service;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.devarchi33.config.AwsConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by donghoon on 2016. 2. 2..
 */
public class EC2GetStatus {

    private AnnotationConfigApplicationContext ctx;

    public EC2GetStatus() {
        this.ctx = new AnnotationConfigApplicationContext();
        ctx.register(AwsConfig.class);
    }

    public DescribeInstancesResult getEc2Status() {
        ctx.refresh();
        AmazonEC2Client ec2Client = ctx.getBean("AmazonEC2Client", AmazonEC2Client.class);
        ec2Client.setEndpoint("ec2.ap-northeast-2.amazonaws.com");
//        String serviceName = ec2Client.getServiceName(); //output: ec2
        DescribeInstancesResult ec2Status = ec2Client.describeInstances();
        return ec2Status;
    }
}
