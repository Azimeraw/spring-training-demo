package com.example.demo;
import com.iszo.example.demo.BookForm;
import com.iszo.example.demo.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.stereotype.Component;
import org.apache.camel.Processor;


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

                            }
                        })

                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("hello");

                        BookForm bookForm=exchange.getIn().getBody(BookForm.class);

                        bookForm.setId("232");
                        exchange.getIn().setBody(bookForm);
                    }
                })
                .marshal(jaxbFormat(ObjectFactory.class))
                .to("file:D:\\2014\\Freelance\\ISZO\\desti?fileName=book.json");
    }
}
