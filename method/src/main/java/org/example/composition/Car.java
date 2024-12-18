package org.example.composition;

public class Car {

    public String modelName;
    public Engine engine;
    public int acceleration;

    public Car(String modelName, Engine engine) {
        this.modelName = modelName;
        this.engine = engine;
    }// Car() end
    
    // 현재 속도는 마력 * 10만 인 메서드
    public void horsepowerOfTheEngine() {
        acceleration = engine.horsepower * 10;
        System.out.printf("현재마력: %d\n가속도: %d%n", engine.horsepower, acceleration);
    }// horsepowerOfTheEngine() end
}
