package com.example.firebase.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    public static  String name,address,designation,department;

    public Employee() {
        //Datasnapshot.getvalue()
    }

    public Employee(String name, String address, String designation, String department) {
        this.name = name;
        this.address = address;
        this.designation = designation;
        this.department = department;
    }
    @Exclude
    public static Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name );
        result.put("address", address);
        result.put("designation", designation);
        result.put("department", department);
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
