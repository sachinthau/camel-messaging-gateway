package com.sachintha.camel.camel_messaging_gateway.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.ExchangePattern;

@Component
public class SftpToRabbitRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("sftp://user@localhost:2222/upload?password=pass&delete=true&delay=10000")
            .routeId("sftp-to-rabbit")
            .convertBodyTo(String.class)
            .log("Received file from SFTP: ${file:name}")
            .to(ExchangePattern.InOnly, "spring-rabbitmq:email-exchange?routingKey=email-queue")
            .log("Forwarded SFTP file content to RabbitMQ");
    }
}