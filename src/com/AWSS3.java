package com.s3.java;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.nio.file.Path;

public class AWSS3 {

    public static void main(String[] args) {
        String accessKey = "AKIAWQUOZ3GRVBUIJUIZ";
        String secretKey = "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";
        String bucketName = "reports-tms";
        String regionName = "eu-north-1";

        File baseFolder = new File("E:\\Project\\TeachMeSkills_Final_Assignment\\src\\com\\static");

        if (!baseFolder.isDirectory()) {
            System.err.println("Path is not a directory: " + baseFolder.getPath());
            return;
        }

        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        S3Client s3Client = S3Client
                .builder()
                .region(Region.of(regionName))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        uploadFiles(s3Client, baseFolder, bucketName);
    }

    private static void uploadFiles(S3Client s3Client, File folder, String bucketName) {
        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                uploadFiles(s3Client, file, bucketName);
            } else if (file.isFile() && file.getName().endsWith(".txt")) {
                String key = file.getPath().replace("\\", "/");
                System.out.println("Uploading: " + file.getPath());

                PutObjectRequest request = PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .build();

                s3Client.putObject(request, Path.of(file.toURI()));
                System.out.println("Uploaded: " + file.getPath());
            }
        }
    }
}
