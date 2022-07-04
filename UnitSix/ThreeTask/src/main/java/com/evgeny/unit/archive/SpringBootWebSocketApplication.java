package com.evgeny.unit.archive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//https://betacode.net/10719/create-a-simple-chat-application-with-spring-boot-and-websocket
@SpringBootApplication
public class SpringBootWebSocketApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebSocketApplication.class, args);
    }
}
