
/*
package com.example.demo;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


@Component
public class ExampleRouteBuilder extends EndpointRouteBuilder {

    protected static final String ERROR_URI = "direct:error";
    static final String ARCHIVE_URI = "file:${header.archive_write_location}?fileName=${header.archive_write_filename}&autoCreate=true";


    @Override
    public void configure() throws Exception {

        from(ERROR_URI).
                onException(Exception.class).continued(true).end().
                routeId("ERROR_ROUTEID").
                to(log("An error occurred").level(String.valueOf(Level.ERROR))).
                toD(ARCHIVE_URI);

    }}

*/
























