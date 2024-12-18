package org.example.interfaceprac.library;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("해리포터", 1, "위치");
        System.out.println(book.ID);
        System.out.println(book.title);
        System.out.println(book.location);
        System.out.println(book.isBorrowed);

        book.isBorrowed();

        
        
    }
}
