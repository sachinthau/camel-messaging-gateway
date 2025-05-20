package com.sachintha.camel.camel_messaging_gateway.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitToSmtpRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("spring-rabbitmq:email-exchange?routingKey=email-queue")
            .routeId("rabbit-to-smtp")
            .log("Consuming message from RabbitMQ: ${body}")
            .to("smtp://localhost:1025?to=test@example.com&subject=Message%20from%20RabbitMQ&from=noreply@example.com")
            .log("Sent email via SMTP with message body");
    }
}
