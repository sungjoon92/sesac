package org.example.inheritanceprac;

public class Bus extends Vehicle {
    // 최대 연료
    protected static final int MAX_FUEL = 300;
    // 승객 인원수
    protected int passemgerCount;

    // 버스 생성자 함수
    public Bus(String modelName) {
        super(modelName);
        this.passemgerCount = 0;
    }// Bus() end

    // 승객 추가
    public int addPassenger(int amount) {
        passemgerCount += amount;
        return passemgerCount;
    }// addPassenger() end


    // 연료 넣기
    public int addFuel(double amount) {
        fuel += amount;
        if (fuel > MAX_FUEL) {
            fuel = MAX_FUEL;
        }
        return (int) fuel;
    }// addFuel() end
}
