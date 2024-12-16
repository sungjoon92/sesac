package org.example.inheritanceprac;

public class Cat extends Animal {
    //  생성자 함수
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        String name = getName();
        System.out.println(name + " 애옹");
    }

    // 골골송 이벤트함수
    public void golgolSong() {
        System.out.println("골골골골골골골");
    }// golgolSong() end

}
