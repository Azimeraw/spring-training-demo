//package com.example.demo;
//
//
//import org.apache.camel.Configuration;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//
//@Configuration
//    public class CamelConfig {
//
//        @Autowired
//        private JacksonDataFormat jacksonDataFormat;
//
//        @Bean
//        public RouteBuilder myRouteBuilder() {
//            return new RouteBuilder() {
//                @Override
//                public void configure() throws Exception {
//                    from("direct:start")
//                            .marshal(jacksonDataFormat)
//                            .to("log:output");
//                }
//            };
//        }
//    }
//
//}
