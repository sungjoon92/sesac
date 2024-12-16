package org.example.inheritanceprac;

public class Vehicle {
    protected String modelName;
    protected double speed;
    protected double fuel;
    protected static final int MAX_FUEL = 100;

    // 차량 기본 생성자 함수
    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.speed = 0;
        this.fuel = 0;
    }// Vehicle() end

    // 엑셀 밟을때 속도 증가
    public void accelerator(double amount) {
        this.speed += amount;
        fuel -= amount / 10;
    }// accelerator() end

    // 브레이크시 속도 감소
    public void brakes(int amount) {
        speed -= amount;
        this.speed -= 10;
    }// brakes() end

    // 연료 추가
    public int addFuel(double amount) {
        fuel += amount;
        if (fuel > getMaxFuel()) {
            fuel = getMaxFuel();
        }// if() end
        return (int) fuel;
    }// addFuel() end

    //   최대 연료의 getter 함수 작성
    public int getMaxFuel() {
        return MAX_FUEL;
    }// getMaxFuel() end
}
