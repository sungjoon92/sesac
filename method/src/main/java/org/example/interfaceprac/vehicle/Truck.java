package org.example.interfaceprac.vehicle;

public class Truck extends Vehicle implements CargoLendable{
    @Override
    public void lendMethod() {
        System.out.println("트럭: 랜드 메소드");
    }

    @Override
    void fuelMethod() {
        System.out.println("트럭: 연료 메소드");

    }
}
