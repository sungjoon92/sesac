package org.example.inheritanceprac;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------사람 관련-------");

        Person.introduce();
        Student.introduce();
        Student.study();

        System.out.println("-------------------------------");

        Parent parent = new Parent("부모");
        System.out.println(parent.publicValue);
        System.out.println(parent.protectedValue);
        parent.publicMethod();
        System.out.println("-------------------------------");

        Child child = new Child("자식, 테스트");
        System.out.println(child.publicValue);
        System.out.println(child.protectedValue);

        System.out.println("-------------------------------");

        child.publicMethod();

        child.childMethod();

        System.out.println("-------동물 관련-------");

        Animal animal = new Animal("코기", 3);
        animal.makeSound();
        System.out.println(animal.getAge()+"살");

        Dog dog = new Dog("댕댕이", 3, "진돗코기");
        dog.makeSound();
        System.out.println(dog.breed);

        System.out.println(dog.getAge()+"살");

        Cat cat = new Cat("톰", 5);
        cat.makeSound();
        System.out.println(cat.getAge() + "살");
        cat.golgolSong();

        System.out.println("-------자동차 관련-------");
        Vehicle avante = new Vehicle("avante");
        avante.addFuel(80);
        avante.accelerator(25);
        System.out.println("남은 기름: " + avante.fuel+"L");
        System.out.println("현재 속도: " +avante.speed+"S");
        System.out.println(Vehicle.MAX_FUEL);

        Bus bus = new Bus("버스");
        bus.addFuel(30);
        bus.accelerator(30);
        System.out.println("버스 속도 = " + bus.speed);
        System.out.println("버스 최대 기름 = " + Bus.MAX_FUEL);
        System.out.println("버스 탑승 인원(3) = " + bus.addPassenger(3));
        bus.addFuel(400);
        System.out.println("버스 남은 기름 = " + bus.fuel);
    }

}
