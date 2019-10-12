package com.trj.mysqlwrseparation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@MapperScan("com.trj.mysqlwrseparation.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class MysqlWRSeparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlWRSeparationApplication.class, args);
    }

}
