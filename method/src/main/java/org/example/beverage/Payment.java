package org.example.beverage;

abstract class Payment {
    private int amount;

    public Payment(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // 결제 메서드
    public abstract void paymentProcess(User user, Drink drink);
}
