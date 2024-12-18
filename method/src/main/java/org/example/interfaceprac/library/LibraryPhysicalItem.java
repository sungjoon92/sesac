package org.example.interfaceprac.library;

public abstract class LibraryPhysicalItem extends LibraryItem{
    // 위치
    String location;

    public LibraryPhysicalItem(String title, int ID, String location) {
        super(title, ID);
        this.location = location;
    }
// 위치 메서드
    abstract void findLocation();

//    public abstract void isBorrowed();
}
