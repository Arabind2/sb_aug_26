package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.jt.Engine;

@Component("petrol")
@Primary
public class PetrolEngine implements Engine {
//PetrolEngine petrolEngine;
    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol Engine starting");
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol Engine stopping");
    }
    
}
