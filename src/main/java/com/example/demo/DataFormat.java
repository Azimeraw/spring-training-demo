//package com.example.demo;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.camel.Exchange;
//import org.apache.camel.spi.DataFormat;
//import org.springframework.stereotype.Component;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//
//@Component
//public class JacksonDataFormat implements DataFormat {
//
//    private final ObjectMapper objectMapper;
//
//    public JacksonDataFormat(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
//        objectMapper.writeValue(stream, graph);
//    }
//
//    @Override
//    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
//        return objectMapper.readValue(stream, Object.class);
//    }
//}
