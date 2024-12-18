package org.example.interfaceprac.vehicle;

public class Bus extends Vehicle implements PassengerBoardable{

    @Override
    public void boardMethod() {
        System.out.println("버스: 보드 메소드");
    }

    @Override
    void fuelMethod() {
        System.out.println("버스: 연료 메소드");
    }

    @Override
    void speedMethod() {
        System.out.println("버스: 차량 스피드 메소드");
    }
}
