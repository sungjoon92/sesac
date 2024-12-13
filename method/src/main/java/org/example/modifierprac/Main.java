package org.example.modifierprac;

public class Main {
    public static void main(String[] args) {

        Person ps = new Person("쮸니", 3, 177.0);
        System.out.println(ps.getName());
        System.out.println(ps.age);
        System.out.println(ps.height);

        ps.setName("탱이");
        ps.age = 5;
        ps.height = 180;
        System.out.println(ps.getName());
        System.out.println(ps.age);
        System.out.println(ps.height);

        ps.exercias();
        ps.walking();
        ps.study();


    }
}
