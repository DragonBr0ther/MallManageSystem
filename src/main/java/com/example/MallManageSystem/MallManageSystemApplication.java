package com.example.MallManageSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.MallManageSystem.dao.mapper")
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class MallManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallManageSystemApplication.class, args);
    }
}
