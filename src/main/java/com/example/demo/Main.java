package com.example.demo;

import com.iszo.example.demo.book.BookForm;
import com.iszo.example.demo.book.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.stereotype.Component;

@Component
public class Main extends RouteBuilder {


    public static JaxbDataFormat jaxbFormat(Class<?> clazz) {
        try {
            return new JaxbDataFormat(JAXBContext.newInstance(clazz));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }}


    @Override
    public void configure() throws Exception {

        System.out.println("kkkkkkkkkk");
        from("file:D:\\2014\\Freelance\\ISZO\\data")
                .routeId("bookstore")
               .unmarshal(jaxbFormat(ObjectFactory.class))
                .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {
                                System.out.println("hello++++");
                                BookForm bookForm=exchange.getIn().getBody(BookForm.class);
                                bookForm.setAuthor("Azimeraw");
                                bookForm.setId("1212");
                                bookForm.setGenre("gegegege");
                                bookForm.setTitle("Title");
                                exchange.getIn().setBody(bookForm);

                            }
                        })
               //.transform(method(EmployeeToJsonDataformatter.class))
               .marshal(jaxbFormat(ObjectFactory.class))
                .to("file:D:\\2014\\Freelance\\ISZO\\desti?fileName=book.xml");

        // Employee class
        from("file:D:\\2014\\Freelance\\ISZO\\source")
                .routeId("employee")
               .unmarshal(jaxbFormat(com.iszo.example.demo.employe.ObjectFactory.class))
                .transform(method(TransformXML.class))
                .marshal(jaxbFormat(com.iszo.example.demo.employee1.ObjectFactory.class))
                .to("file:D:\\2014\\Freelance\\ISZO\\source2?fileName=employee1.xml");
    }

}
