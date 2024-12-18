package org.example.interfaceprac.vehicle;

public class Main {

    public static void main(String[] args) {
        Bus bus = new Bus();

        bus.boardMethod();
        bus.fuelMethod();
        bus.speedMethod();


        Truck truck = new Truck();
        truck.lendMethod();
        truck.fuelMethod();
        truck.speedMethod();


        Brucks brucks = new Brucks();
        brucks.speedMethod();
        brucks.boardMethod();
        brucks.fuelMethod();
        brucks.lendMethod();
    }
}
