package com.ycx.Exam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class ExamSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamSysApplication.class, args);
    }

}
