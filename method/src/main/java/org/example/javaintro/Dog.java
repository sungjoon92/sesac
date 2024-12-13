package org.example.javaintro;

public class Dog {
    public String dogType;
    public String name;
    public String doging;

    public static int count;

    public static void Dog(String dogType, String name, String doging) {
        count++;
        System.out.println(dogType+name+doging+count);
    }

    public static void seat(String name) {
        System.out.println("나 " + name + "앉았다");
    }

    public static void hand() {
//        System.out.println(this.name + "손");
        System.out.println("손");
    }

    String dogs() {

        return "견종: " + dogType + " 이름: " + name + " 행동: " + doging;
    }

//    public static void Dog(){
//        System.out.println("dog good");
//    }

}
