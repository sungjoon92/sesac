package org.example.javaintro;

public class PrivateModifier {
    public int publicNum;
    private int privateNum;

    public int getPrivateNum() {
        return privateNum;
    }
    public int getPrivateNum2() {
        return privateNum++;
    }

    public void setPrivateNum(int privateNum) {
        this.privateNum = privateNum;
    }

    public void PublicHi() {
        System.out.println("h1, public");
    }

    private void privateHi() {
        System.out.println("h1, private");
    }

    public void sayHi() {
        privateHi();
    }


}
