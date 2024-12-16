package org.example.javaintro;

import org.example.Bank.BankAccount;
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



        BankAccount myAccount = new BankAccount("abc123");
        // 입금
        myAccount.deposit(10000);
        myAccount.getBalance("abc123");
        myAccount.getBalance("asdasdas");
        // 출금
        myAccount.withdraw(5000, "abc123");
        myAccount.getBalance("abc123");

        
        //초기 유효성 검사
//        String myPassword = "abc";
//        if (BankAccount.validateInitialPassword(myPassword)) {
//            new BankAccount(myPassword);
//        } else {
//            System.out.println("로그인 실패");
//        }
        // 성공했어? 해! 보다 실패했어? 하지마! 가 더 잘좋음
        String myPassword = "abc";
        if (!BankAccount.validateInitialPassword(myPassword)) {
            System.out.println("로그인 실패");
            return;
        } else {
            new BankAccount(myPassword);
        }
    }// if() end


}
