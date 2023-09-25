package com.example.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Processor;
import java.util.StringTokenizer;

@Component
public class Main extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        System.out.println("kkkkkkkkkk");
        from("file:D:\\2014\\Freelance\\ISZO\\data")

                //.routeId("booktoesb")
                .process(new Processor() {

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        //read source data
                        Message inputData=exchange.getIn();
                        String data= inputData.getBody(String.class);
                        StringTokenizer stringTokenizer=new StringTokenizer(data,",");
                        String bookName=stringTokenizer.nextToken();
                        String author=stringTokenizer.nextToken();
                        String description=stringTokenizer.nextToken();
                        String modifiedData="{bookName:"+bookName+",author:"+author+",description:"+description+"}";
                        Message output=exchange.getMessage();
                        output.setBody(modifiedData);
                    }
                })
                .to("file:D:\\2014\\Freelance\\ISZO\\desti?fileName=book.json");
    }
}
