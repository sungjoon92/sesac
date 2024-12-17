package org.example.interfaceprac.vegicle;

public class Brucks extends Vehicle implements CargoLendable, PassengerBoardable {

    @Override
    public void lendMethod() {
        System.out.println("Brucks: 버트럭 메소드");
    }

    @Override
    public void boardMethod() {
        System.out.println("Brucks: 보드 메소드");
    }

    @Override
    void fuelMethod() {
        System.out.println("Brucks: 연료 메소드");
    }
}
