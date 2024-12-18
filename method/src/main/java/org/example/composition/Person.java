package org.example.composition;

public class Person {
    public String name;
    public Pencil pencil;
    public Pencil[] pencils;

    public Person(String name, Pencil pencil) {
        this.name = name;
        this.pencil = pencil;
    }

    public Person(String name,  Pencil[] pencils) {
        this.name = name;
        this.pencils = pencils;
    }

    public void write(){
//        System.out.println("글씨를 쓴다");
        pencil.write();
    }

    public void writeMany(){
        for (Pencil p : pencils) {
            p.write();
        }
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }
}
