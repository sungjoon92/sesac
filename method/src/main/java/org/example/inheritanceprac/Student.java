package org.example.inheritanceprac;
public class Student extends Person {

//    String name;
//    int age;
    int studentNum;


//    public Student(String name, int age, int studentNum) {
//        this.name = name;
//        this.age = age;
//        this.studentNum = studentNum;
//    }


    public static void introduce() {
        System.out.println("안녕 난 학생이야");
    }

    public static void study() {
        System.out.println("공부");
    }
}
