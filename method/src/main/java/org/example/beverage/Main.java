package org.example.beverage;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        // 일반 사용자 추가
        User jooni = new User("쮸니", 10000, 10000);
        System.out.println(jooni.getName());
        System.out.println(jooni.getCardMoney());
        System.out.println(jooni.getCashMoney());


        // 관리자추가
        Manager manager = new Manager("리자", 50000);
        System.out.println(manager.getName());
        System.out.println(manager.getMoney());


        // 음료 추가
        for (int i = 1; i <= 10; i++) {
            Drink.addDrink("환타", 2500);
        }
        for (int i = 1; i <= 5; i++) {
            Drink.addDrink("코카콜라", 2500);
        }
        for (int i = 1; i <= 10; i++) {
            Drink.addDrink("칠성사이다", 2500);
        }
        for (int i = 1; i <= 8; i++) {
            Drink.addDrink("비타500", 500);
        }
        for (int i = 1; i <= 4; i++) {
            Drink.addDrink("레쓰비", 700);
        }
        for (int i = 1; i <= 7; i++) {
            Drink.addDrink("스프라이트", 2000);
        }
        for (int i = 1; i <= 3; i++) {
            Drink.addDrink("밀키스", 1500);
        }
        for (int i = 1; i <= 9; i++) {
            Drink.addDrink("솔의눈", 1200);
        }
        Drink.addDrink();

        // 음료 목록 출력
        List<Drink> drinkList = Drink.getDrinkList();
        System.out.println(drinkList);

        // 카드 결제
        Payment cardPayment = new CardPayment(9000);
        cardPayment.paymentProcess(jooni, drinkList.get(0));
        cardPayment.paymentProcess(jooni, drinkList.get(1));
        cardPayment.paymentProcess(jooni, drinkList.get(2));


        // 현금 결제
        Payment cashPayment = new CashPayment(15000);
        cashPayment.paymentProcess(jooni, drinkList.get(0));

    }
}
