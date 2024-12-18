package org.example.interfaceprac.library;

public class Eboox extends LibraryItem implements Downloadable {

    // 다운로드 가능해?
    boolean isDownloadable;

    public Eboox(String title, int ID) {
        super(title, ID);
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

    @Override
    public void download() {

    }

    @Override
    public void isDownloadable() {

    }
}
