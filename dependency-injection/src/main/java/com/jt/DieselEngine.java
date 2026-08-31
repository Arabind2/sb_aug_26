package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.jt.Engine;

@Component
@Primary
public class DieselEngine implements Engine {
//DieselEngine dieselEngine;
    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("Diesel Engine starting");
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("Diesel Engine stopping");
    }
    
}
