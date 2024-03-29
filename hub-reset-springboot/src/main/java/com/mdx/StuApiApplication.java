package com.mdx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Mengdl
 * @date 2023/04/25
 */
@SpringBootApplication
@EnableAsync
public class StuApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuApiApplication.class, args);
    }
}
