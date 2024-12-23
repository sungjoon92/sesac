package org.example.beverage;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("선택하실? 1.");
//        System.out.println(scanner.next());

        User jooni = new User("쮸니", 10000, 10000);
        System.out.println(jooni.getName());
        System.out.println(jooni.getCardMoney());
        System.out.println(jooni.getCashMoney());


        Manager manager = new Manager("리자", 50000);
        System.out.println(manager.getName());
        System.out.println(manager.getMoney());
        
        // 카드 결제
        Payment cardPayment = new CardPayment(9000);
        cardPayment.paymentProcess(jooni);

        // 현금 결제
        Payment cashPayment = new CashPayment(15000);
        cashPayment.paymentProcess(jooni);

        // 음료
        List<Drink> drink = new ArrayList<>();
        drink.add(new Drink("환타", 2500, 10));
        drink.add(new Drink("코카콜라", 2500, 10));
        drink.add(new Drink("칠성사이다", 2500, 10));
        drink.add(new Drink("환타", 2500, 10));
        drink.add(new Drink("비타500", 500, 8));
        drink.add(new Drink("레쓰비", 700, 30));
        drink.add(new Drink("스프라이트", 2000, 22));
        drink.add(new Drink("밀키스", 1500, 55));
        drink.add(new Drink("솔의눈", 1200, 30));
        System.out.println(drink);

    }
}
