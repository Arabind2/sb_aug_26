package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    // Engine engine=new Engine();

    //DI(Dependency injection)
    //DI is a mechanism in which Spring Container automatically inject the bean inside a class reference variable
    //In simple word Spring container automatically assigns the address of the bean another class reference variable
    
    //1. Field Based Injection- NR
    // @Autowired
    // private Engine engine;

    //2. Setter Based Injection - R
    // private Engine engine;
    // @Autowired
    // public void setEngine(Engine engine){
    //     // System.out.println("Parameter engine : "+engine);
    //     // System.out.println("Variable engine : "+this.engine);
        
    //     this.engine=engine;
    // }
    
    //3. Constructor Based Injection - HR
    private Engine engine;
    @Autowired
    public Car(@Qualifier("petrol") Engine engine){
        this.engine=engine;
        System.out.println("Parameterized constructor.");
    }

// public Car(){
//     System.out.println("Non parameterized Constructor.");
// }


    public void startCar(){
        
        engine.startEngine();

        System.out.println("Car is started.");
    }

    public void stopCar(){
        // Engine engine=new Engine();
        engine.stopEngine();

        System.out.println("Car is stoped.");
    }
}
