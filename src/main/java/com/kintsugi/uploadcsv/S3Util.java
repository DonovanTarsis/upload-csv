package com.kintsugi.uploadcsv;

import java.io.File;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Util {

    private static final String BUCKET = "bucket-group-7";
    
    
    
    public static void sendPath(String file_path, String bucket_name, String key_name) {
        
        System.out.println(("Uploading {} to S3 bucket {}...\n"));

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
        
        try {
            s3.putObject(bucket_name, key_name, new File(file_path));
        } catch (AmazonServiceException e) {
            System.out.println(e.getMessage());
            //System.exit(1);
        }

    }

    public static void main (String args[]){
        sendPath("/Users/carolina.marques/Desktop/print.png", "bucket-group-7", "file");
    }
}
