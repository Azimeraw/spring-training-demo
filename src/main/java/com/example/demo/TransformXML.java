package com.example.demo;

import com.iszo.example.demo.employee1.ObjectFactory;
import com.iszo.example.demo.employee1.Employee;
import org.springframework.stereotype.Component;

@Component
public class TransformXML {
    ObjectFactory obj=new ObjectFactory();
    public Employee transformXML (com.iszo.example.demo.employe.Employee employee){
        Employee val = obj.createEmployee();
        val.setName(employee.getName());
        val.setEmployeeid((byte)employee.getEmployeeid());
        val.setDepartment(createDeartement(employee.getDepartment()));
        return val;
    }

    private Employee.Department createDeartement(com.iszo.example.demo.employe.Employee.Department department) {
        Employee.Department dept = obj.createEmployeeDepartment();
        dept.setCty(department.getCity());
        dept.setDepartmentName(department.getDepartmentname());
        dept.setCountry(department.getCountry());
        dept.setAddr(department.getAddress());
        return dept;
    }


}