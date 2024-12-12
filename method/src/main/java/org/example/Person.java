package org.example;

public class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    String person(){
        return name + age + "살";
    }

}
