package org.example.composition;

public class Car implements Tool{
    public String model;
    public Engine engine; // 컴포지션
    public int speed;

    public Car(){}

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.speed = 0;
    }

    public void speedUP(){
        int amount = engine.horsePower;
        speed += amount;

    }

    @Override
    public void use() {
        speedUP();
    }
}
