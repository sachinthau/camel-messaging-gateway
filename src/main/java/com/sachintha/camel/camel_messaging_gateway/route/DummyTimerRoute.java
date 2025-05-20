// package com.sachintha.camel.camel_messaging_gateway.route;

// import org.apache.camel.builder.RouteBuilder;
// import org.springframework.stereotype.Component;

// @Component
// public class DummyTimerRoute extends RouteBuilder {
//     @Override
//     public void configure() {
//         from("timer://keepalive?period=5000")
//             .routeId("keep-alive")
//             .log(">> Camel is alive and ticking: ${date:now}");
//     }
// }
