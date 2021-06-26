package com.example.patientrecordsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Domain.Entity"})
@ComponentScan(basePackages = { "Controller"} )
public class PatientRecordSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientRecordSystemApplication.class, args);
    }
}

