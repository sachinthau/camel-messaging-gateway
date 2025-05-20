package com.sachintha.camel.camel_messaging_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelMessagingGatewayApplication {

    public static void main(String[] args) {
        System.out.println(">>> Starting Camel Messaging Gateway...");
        SpringApplication.run(CamelMessagingGatewayApplication.class, args);
        System.out.println(">>> SpringApplication.run() exited!");
    }
}
