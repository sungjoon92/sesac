package org.example;

public class Car {
    String model;
    int speed;

    public Car(String model) {
        this.model = model;
        this.speed = 0;
    }

    int increaseSpeed() {
        this.speed += 10;
        return  this.speed;
    }
    int decreaseSpeed() {
        if (this.speed != 0) {
            this.speed -= 10;
        }
        return  this.speed;
    }

    void showInfo() {
        System.out.println("모델명 : " + this.model + " 속도 : " + this.speed);
        System.out.printf("모델명 : %s 속도 : %d \n", model, speed);
    }

    int increaseSpeedByAmount(int amount) {
        this.speed += amount;
        return amount;
    }
}
