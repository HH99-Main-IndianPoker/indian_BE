package com.example.socketpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SocketPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketPracticeApplication.class, args);
    }

}
