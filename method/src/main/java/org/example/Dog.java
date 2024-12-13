package org.example;

public class Dog {
    String dogType;
    String name;
    String doging;

    static int count;

    public Dog(String dogType, String name, String doging) {
        this.dogType = dogType;
        this.name = name;
        this.doging = doging;
        count++;
    }

    void seat(){
        System.out.println("나 "+this.name+ "앉았다");
    }

    void hand(){
        System.out.println(this.name + "손");
    }

    String dogs(){

        return "견종: " + dogType +" 이름: "+ name +" 행동: "+ doging;
    }

}
