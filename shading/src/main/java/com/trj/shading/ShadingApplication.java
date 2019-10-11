package com.trj.shading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.trj.shading.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class ShadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadingApplication.class, args);
    }

}

