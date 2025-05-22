package com.sachintha.camel.camel_messaging_gateway.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.ExchangePattern;

@Component
public class JmsToRabbitRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("jms:queue:external-jms-queue")
            .routeId("jms-to-rabbit")
            .log("Received JMS message: ${body}")
            .to(ExchangePattern.InOnly, "spring-rabbitmq:email-exchange?routingKey=email-queue")
            .log("Forwarded JMS message to RabbitMQ");
    }
}
