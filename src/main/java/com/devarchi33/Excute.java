package com.devarchi33;

import com.devarchi33.util.FileWriteInstanceStatus;

/**
 * Created by donghoon on 2016. 2. 2..
 */
public class Excute {
    public static void main(String args[]) {
        FileWriteInstanceStatus fwis = new FileWriteInstanceStatus();
        Boolean check = fwis.writeJsonFile();

        if (check) {
            System.out.println("File is created.");
        } else {
            System.out.println("File is not created beacuse something wrong...");
        }
    }
}
