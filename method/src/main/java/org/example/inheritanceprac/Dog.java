package org.example.inheritanceprac;

public class Dog extends Animal {

    protected String breed;

// 생성자 함수
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }// Dog() end


    @Override
    public void makeSound() {
        String name = getName();
        System.out.println(name + " 멍멍");
    }

}

//
//dog.makesound() => name 멍멍
//cat.makdsound() => name 야용
