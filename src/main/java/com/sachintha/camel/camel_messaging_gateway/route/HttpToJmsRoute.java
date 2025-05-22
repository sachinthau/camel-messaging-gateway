package com.sachintha.camel.camel_messaging_gateway.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HttpToJmsRoute extends RouteBuilder {
    @Override
    public void configure() {
        log.info(">>> HttpToJmsRoute starting on port 8085...");

        from("undertow:http://0.0.0.0:8085/api/send-jms")
            .routeId("http-to-jms")
            .log(">>> Received HTTP POST: ${body}")
            .to("jms:queue:external-jms-queue")
            .log(">>> Forwarded HTTP body to ActiveMQ JMS queue");
    }
}
