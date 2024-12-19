package org.example.collectionprac;

public class Student{
    public String name;
    public int age;
    public String subject;
    public int score;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void subjectScore(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}
