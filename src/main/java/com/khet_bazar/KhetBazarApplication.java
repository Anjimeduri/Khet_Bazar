package com.khet_bazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.khet_bazar")
public class KhetBazarApplication {
    public static void main(String[] args) {
        SpringApplication.run(KhetBazarApplication.class, args);
    }
}