package org.example.interfaceprac;

public abstract class Animal {

    protected String name;
    protected int age;

    // 동물 생성자 함수
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }// Animal() end

    public void makeSound() {
        System.out.println("왕왕");
    }

}
