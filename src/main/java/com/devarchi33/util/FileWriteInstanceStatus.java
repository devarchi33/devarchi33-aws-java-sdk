package com.devarchi33.util;

import com.devarchi33.aws.service.EC2GetStatus;
import com.devarchi33.config.UtilConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by donghoon on 2016. 2. 2..
 */
@Component
public class FileWriteInstanceStatus {
    private AnnotationConfigApplicationContext ctx;
    private EC2GetStatus ec2GetStatus;

    public FileWriteInstanceStatus() {
        this.ctx = new AnnotationConfigApplicationContext();
        ctx.register(UtilConfig.class);
        ctx.refresh();
        this.ec2GetStatus = ctx.getBean("EC2GetStatus", EC2GetStatus.class);
    }

    private boolean checkInstance() {
        if (ec2GetStatus != null) {
            System.out.println("Instance is created.");
            return true;
        } else {
            System.out.println("Instance is not created.");
            return false;
        }
    }

    public Boolean writeJsonFile() {
        FileWriteInstanceStatus f = new FileWriteInstanceStatus();
        Boolean checkInstance = f.checkInstance();

        if (checkInstance) {
            String ec2Status = ec2GetStatus.getEc2Status().toString();
            String fileName = "/Users/donghoon/Documents/amazon/Ec2Status.json";
            System.out.println(ec2Status);
            try {
                // 파일 객체 생성
                File file = new File(fileName);

                // true 지정시 파일의 기존 내용에 이어서 작성
                FileWriter fw = new FileWriter(file, true);

                // 파일안에 문자열 쓰기
                fw.write(ec2Status);
                fw.flush();

                // 객체 닫기
                fw.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            throw new NullPointerException("Instance is not created.");
        }
    }
}
