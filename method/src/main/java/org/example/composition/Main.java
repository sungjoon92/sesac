package org.example.composition;

public class Main {
    public static void main(String[] args) {
//        Pencil red = new Pencil("red");
//        Person beemo = new Person("beemo", red);
//
//        beemo.write();
//
//        Pencil blue = new Pencil("blue");
//
//        beemo.setPencil(blue);
//
//        beemo.write();
//        System.out.println();
//
//        Pencil yellow = new Pencil("yellow");
//
//        Pencil[] pencils = {red, blue, yellow};
//        Person lynda = new Person("lynda", pencils);
//
//        lynda.writeMany();
//
//        System.out.println("\nCar");

        Engine e10 = new Engine(10);
        Engine e20 = new Engine(20);

        Car carE10 = new Car("avante", e10);
        Car carE20 = new Car("sonata", e20);

        carE10.speedUP();
        System.out.println(carE10.speed);

        carE20.speedUP();
        System.out.println(carE20.speed);

        // Person
        Pencil pencil = new Pencil("red");

        Person p1 = new Person("beemo", pencil);
        p1.use();

        p1.tool = carE10;

        System.out.println(carE10.speed);
        p1.use();
        System.out.println(carE10.speed);

//        person.use() => 도구로 pencile => 연필을 사용하고
//                .uesr() 도구로 car를 가지고 있다 => 속력을 높이자
        System.out.println("\n Character");

        Character character = new Character(100);
        Gun gun = new Gun(10, 20);
        Sword sword = new Sword(30, 4);

        character.attack();

        character.setWeapon(gun);
        character.attack();

        character.setWeapon(sword);
        character.attack();
        // 문제상황
        // 처음 구현 상황 - 우리는 Weapon과 SpecialAttackable을 따로 분리함.
        //              - Character는 Weapon만 받을 수 있음 => SA이 불가능 함

//        1. Weapon을 Special Attack이라는 것을 분리하지 말고 하나로 합침.
        // Weapon은 기본 SA으로 아무것도 안함을 가짐
//        2. Charater의 SA 메서드 내부에서 Weapon이 SAable을 구현하는지 확인함
        // instanceof 라는 연산자를 사용
//        3. Weapon이 SA을 composition으로 가짐
        // SA이 null인지를 확인해서 진행



    }
}
