package com.s3.java;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyS3 {
    public static void main(String[] args) throws Exception{

        Properties props = new Properties();

        String accessKey = "AKIAWQUOZ3GRVBUIJUIZ";
        String secretKey = "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";

        try {

            props.setProperty("accessKey", accessKey);
            props.setProperty("secretKey", secretKey);

            FileOutputStream output = new FileOutputStream("config.properties");
            props.store(output, "AWS");
            output.close();
            System.out.println("Save");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
