package org.example.beverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drink {
    public String name;
    private int payment;
    private int stockQuantity;

    // 음료 목록을 관리하는 정적 리스트
    private static List<Drink> drinkList = new ArrayList<>();

    public Drink(String name, int payment) {
        this.name = name;
        this.payment = payment;
        this.stockQuantity = getStockQuantity();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    // 음료를 추가하는 정적 메서드
    public static void addDrink() {
        // 스캐너 시작
        Scanner scanner = new Scanner(System.in);

        System.out.print("추가할 음료 이름을 적어주세요: ");
        String name = scanner.next();

        System.out.print("추가할 음료 가격을 적어주세요: ");
//        int payment = Integer.parseInt(scanner.next());
        int payment = scanner.nextInt();

        System.out.print("추가할 음료 수량을 적어주세요: ");
        int stockQuantity = scanner.nextInt();
        
        // 리스트에서 같은 이름의 음료를 검색
        for (Drink drink : drinkList) {
            if (drink.getName().equals(name)) {
                // 음료가 이미 존재하면 수량 증가
                drink.setStockQuantity(drink.getStockQuantity() + stockQuantity);
                System.out.println(name + " 수량 증가: " + drink.getStockQuantity());
                return;
            }
        }

        // 음료가 없으면 새로 추가
        Drink newDrink = new Drink(name, payment);
        newDrink.setStockQuantity(newDrink.getStockQuantity() + stockQuantity);
        drinkList.add(newDrink);
        System.out.println("--------------------------------------");
        System.out.println(newDrink.getName() + " 추가 완료: " + newDrink.getStockQuantity());
    }


    // 음료를 추가하는 정적 메서드
    public static void addDrink(String name, int payment) {

        // 리스트에서 같은 이름의 음료를 검색
        for (Drink drink : drinkList) {
            if (drink.getName().equals(name)) {
                // 음료가 이미 존재하면 수량 증가
                drink.setStockQuantity(drink.getStockQuantity() + 1);
                System.out.println(name + " 수량 증가: " + drink.getStockQuantity());
                return;
            }
        }

        // 음료가 없으면 새로 추가
        Drink newDrink = new Drink(name, payment);
        newDrink.stockQuantity++;
        drinkList.add(newDrink);
        System.out.println("--------------------------------------");
        System.out.println(newDrink.getName() + " 추가 완료: " + newDrink.getStockQuantity());
    }


    // 음료 목록을 반환하는 정적 메서드
    public static List<Drink> getDrinkList() {
        return drinkList;
    }

    @Override
    public String toString() {
        return "drink{" + "이름 ='" + name + '\'' + " 가격 = " + payment + " 수량 = " + stockQuantity + "}\n";
    }
}

