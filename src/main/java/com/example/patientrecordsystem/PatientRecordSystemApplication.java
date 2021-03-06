package com.example.patientrecordsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
// @EnableConfigurationProperties
// @EntityScan(basePackages = {"Domain.Entity"})
// @ComponentScan(basePackages = { "Controller"} )
// @EnableJpaRepositories(basePackages={"Repository"})
public class PatientRecordSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientRecordSystemApplication.class, args);
    }
}

