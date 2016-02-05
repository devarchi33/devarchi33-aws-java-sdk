package com.amazonaws.samples;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.*;

/**
 * Created by donghoon on 2016. 2. 2..
 */
public class EC2Sample {

    public static void main(String[] args) {
        AmazonEC2Client ec2Client = new AmazonEC2Client();
        ec2Client.setEndpoint("ec2.ap-northeast-2.amazonaws.com");

        CreateSecurityGroupRequest createSecurityGroupRequest = new CreateSecurityGroupRequest();
        createSecurityGroupRequest.withGroupName("devarchi33-java-sdk-security-group").withDescription("Made by Java-SDK");
        CreateSecurityGroupResult createSecurityGroupResult = ec2Client.createSecurityGroup(createSecurityGroupRequest);

        IpPermission ipPermission = new IpPermission();
        ipPermission
                .withIpRanges("211.170.163.68/32")
                .withIpProtocol("tcp")
                .withFromPort(22)
                .withToPort(22);

        AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest = new AuthorizeSecurityGroupIngressRequest();
        authorizeSecurityGroupIngressRequest
                .withGroupName("devarchi33-java-sdk-security-group")
                .withIpPermissions(ipPermission);

        ec2Client.authorizeSecurityGroupIngress(authorizeSecurityGroupIngressRequest);

        CreateKeyPairRequest createKeyPairRequest = new CreateKeyPairRequest();
        createKeyPairRequest.withKeyName("devarchi33-java-sdk-key-pair.pem");
        CreateKeyPairResult createKeyPairResult = ec2Client.createKeyPair(createKeyPairRequest);

        KeyPair keyPair;
        keyPair = createKeyPairResult.getKeyPair();
        String privateKey = keyPair.getKeyMaterial();
        System.out.println(privateKey);

        RunInstancesRequest runInstancesRequest = new RunInstancesRequest();
        runInstancesRequest
                .withImageId("ami-249b554a")
                .withInstanceType("t2.micro")
                .withMinCount(1)
                .withMaxCount(1)
                .withKeyName("devarchi33-java-sdk-key-pair.pem")
                .withSecurityGroups("devarchi33-java-sdk-security-group");

        RunInstancesResult runInstancesResult =
                ec2Client.runInstances(runInstancesRequest);

    }
}
