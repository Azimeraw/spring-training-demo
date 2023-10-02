
package com.example.demo.dataFormatter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class DataFormatter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
        from("file:D:\\2014\\Freelance\\ISZO\\source2")
                .unmarshal().jacksonXml()
                .marshal(jacksonDataFormat)
                .to("file:D:\\2014\\Freelance\\ISZO\\desti?fileName=emp.json");
    }
}
