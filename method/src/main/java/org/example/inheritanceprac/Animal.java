package org.example.inheritanceprac;

public class Animal {

    private String name;
    private int age;

    // 동물 생성자 함수
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }// Animal() end

    // 동물소리 함수
    public void makeSound() {
        System.out.println("멍냐옹");
    }// makeSound() end

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
