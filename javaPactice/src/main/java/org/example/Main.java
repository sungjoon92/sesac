package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");
        String word1 = new String("hello");
        String word2 = new String("hello");
        String word3 = "hello";
        String word4 = "hello";

        System.out.println("word1 : " + System.identityHashCode(word1));
        System.out.println("word2 : " + System.identityHashCode(word2));
        System.out.println("word3 : " + System.identityHashCode(word3));
        System.out.println("word4 : " + System.identityHashCode(word4));
//      System.identityHashCode()는 객체의 원래 해시코드를 보여준다.
//      해시코드는 서로 다른 객체에게 다르게 부여되는 객체 자체의 고유한 번호이다.





    }
}