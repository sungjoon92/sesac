package org.example.interfaceprac.library;

public interface Borrowable {

    // 빌리기
    void borrowItem();

    //반납하기
    void returnItem();

    //빌릴수 있어?
    void isBorrowed();
}
