package org.example.modifierprac.temp;

import org.example.modifierprac.Person;

public class Main {
    public static void main(String[] args) {
        Person ps = new Person("쮸니", 3, 177.0);
        System.out.println(ps.getName());
        System.out.println(ps.age);
        System.out.println(ps.getHeight());
    }
}
