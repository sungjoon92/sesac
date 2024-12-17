package org.example.interfaceprac;

public class Main {
    public static void main(String[] args) {
        Ractangle ractangle = new Ractangle();
        System.out.println(ractangle.calculateArea());

        Triangle triangle = new Triangle();
        System.out.println(triangle.calculateArea());


        Animal dog = new Dog("뽀삐", 3, "dkdkdkd");
        dog.makeSound();

        Animal cat = new Cat("냥냥이", 5);

        cat.makeSound();
//        ((Cat) cat).grr();
        makeThemSound(dog);
        makeThemSound(cat);

        System.out.println("-----------------------------------------------");

        // 게임정보

        Warrior warrior = new Warrior("쮸니");
        warrior.info();
        for (int i = 1; i < 2; i++) {
        warrior.levelUp();
        }
        warrior.info();

        // 분노게이지 상승 (최대100)
        for (int i = 0; i < 80; i++) {
          warrior.angerGauge();
        }// for() end


    }


    public static void makeThemSound(Animal animal) {
        System.out.println("소리쳐!");
        animal.makeSound();
    }
}
