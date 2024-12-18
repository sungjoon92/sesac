package org.example.interfaceprac.vehicle;

public abstract class Vehicle {

    protected int maxfuel = 100;

    // 연료 관련
    abstract void fuelMethod();
    // 속도 관련
//    abstract void speedMethod();

    void speedMethod() {
        System.out.println("차량 스피드 메소드");
    }
    
}
