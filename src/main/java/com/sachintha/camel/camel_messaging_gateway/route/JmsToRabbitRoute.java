// package com.sachintha.camel.camel_messaging_gateway.route;

// import org.apache.camel.builder.RouteBuilder;
// import org.springframework.stereotype.Component;

// @Component
// public class JmsToRabbitRoute extends RouteBuilder {
//     @Override
//     public void configure() {
//         from("jms:queue:external-jms-queue")
//             .routeId("jms-to-rabbit")
//             .log("Received JMS message: ${body}")
//             .to("rabbitmq:my-exchange?queue=my-queue&routingKey=jms.key&autoDelete=false")
//             .log("Forwarded JMS message to RabbitMQ");
//     }
// }
