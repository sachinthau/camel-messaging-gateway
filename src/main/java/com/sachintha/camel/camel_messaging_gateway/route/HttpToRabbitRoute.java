package com.sachintha.camel.camel_messaging_gateway.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.ExchangePattern;

@Component
public class HttpToRabbitRoute extends RouteBuilder {
    @Override
    public void configure() {
        log.info(">>> HttpToRabbitRoute starting on port 8085...");

        from("undertow:http://0.0.0.0:8085/api/send")
            .routeId("http-to-rabbit")
            .log(">>> Received HTTP POST: ${body}")
            .to(ExchangePattern.InOnly, "spring-rabbitmq:email-exchange?routingKey=email-queue")
            .log(">>> Forwarded HTTP body to RabbitMQ");
    }
}
