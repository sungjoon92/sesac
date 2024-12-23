package org.example.beverage;

public class User {
    private String name;
    private int cardMoney;
    private int cashMoney;


    public User(String name, int cardMoney, int cashMoney) {
        this.name = name;
        this.cardMoney = cardMoney;
        this.cashMoney = cashMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(int cardMoney) {
        this.cardMoney = cardMoney;
    }

    public int getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(int cashMoney) {
        this.cashMoney = cashMoney;
    }
}
