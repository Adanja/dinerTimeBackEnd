package com.example.demosetupproject;

import com.example.demosetupproject.controller.ImageUploadController;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.File;

@SpringBootApplication

public class DemosetupprojectApplication {

    public static void main(String[] args) {
//        Volgens tutorial moet je hier definiëren dat je een file wilt uploaden
        new File(ImageUploadController.uploadDirectory).mkdir();

        SpringApplication.run(DemosetupprojectApplication.class, args);
    }


}
