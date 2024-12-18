package org.example.interfaceprac.library;

public class DVD extends LibraryPhysicalItem{
    public DVD(String title, int ID, String location) {
        super(title, ID, location);
    }

    @Override
    void findLocation() {

    }

    @Override
    public void borrowItem() {

    }

    @Override
    public void returnItem() {

    }

    @Override
    public void isBorrowed() {

    }
}
