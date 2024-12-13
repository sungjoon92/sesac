package org.example.javaintro;

import org.example.javaintro.temp.DefaultModifier;

public class Main {
    public static void main(String[] args) {


        PrivateModifier pm = new PrivateModifier();
        pm.publicNum = 100000;
        System.out.println(pm.publicNum);
        System.out.println(pm.getPrivateNum());
        pm.setPrivateNum(100);
        System.out.println(pm.getPrivateNum());
        pm.PublicHi();
        pm.sayHi();
        System.out.println(pm.getPrivateNum2());
        System.out.println(pm.getPrivateNum2());

        DefaultModifier df = new DefaultModifier();
        df.publicString = "dd";
        System.out.println(df.publicString);
        System.out.println(df.getPrivateString());


    }
}
