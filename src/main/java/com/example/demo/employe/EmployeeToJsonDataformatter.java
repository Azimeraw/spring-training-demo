package com.example.demo.employe;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.iszo.example.demo.book.BookForm;
import com.iszo.example.demo.employe.Employee;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.juneau.json.JsonSerializer;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import static org.apache.camel.spi.RestConfiguration.RestBindingMode.xml;

@Component
public class EmployeeToJsonDataformatter implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("employe data");
        Employee employee=exchange.getIn().getBody(Employee.class);
        employee.setEmployeeid(100);
        employee.setName("Azimeraw");
        Employee.Department department=new Employee.Department();
        department.setDepartmentname("Software");
        department.setCountry("ETH");
        department.setAddress("Addis Ababa 100");
        department.setCity("Addis Ababa");
        employee.setDepartment(department);

        //used to xml to json
//        mlMapper xmlMapper = new XmlMapper();
//        employee = xmlMapper.readValue(xml,Employee.class);
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(employee);

        exchange.getIn().setBody(Employee.class);
    }

/*
    @Override
    public void configure() throws Exception {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
        jacksonDataFormat.setPrettyPrint(true);
        jacksonDataFormat.enableFeature(SerializationFeature.WRAP_ROOT_VALUE);

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                System.out.println("Employee to json");
                from("file:D:\\2014\\Freelance\\ISZO\\source?fileName=employe.xml")
                        .unmarshal().jacksonXml(Employee.class)
                        .marshal(jacksonDataFormat)
                        .to("file:D:\\2014\\Freelance\\ISZO\\source2?fileName=employe.json")
                        .end();
            }
        });
        context.start();
        Thread.sleep(10000); // Prevent to Camel to shutdown and don't run the route
        context.stop();
        context.close();
*/
//        XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
//        xmlJsonFormat.setForceTopLevelObject(true);
//
//        // from XML to JSON
//
//        //#1
//        from("direct:marshal").marshal(xmlJsonFormat).to("mock:json");
//        from("file:D:\\2014\\Freelance\\ISZO\\source").marshal(xmlJsonFormat).to("file:D:\\2014\\Freelance\\ISZO\\source2");
    }

