package com.jt.intro_to_web;

public class Person {
    private String name; //name match the queryParamter name
    private String phone; //phone match the queryParamter name
    
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
        System.out.println("Name setter");
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
        System.out.println("phone setter");
    }

    
}
