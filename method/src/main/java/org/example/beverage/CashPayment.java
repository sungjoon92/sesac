package org.example.beverage;

public class CashPayment extends Payment {

    public CashPayment(int amount) {
        super(amount);
    }

    //현금결제 로직
    @Override
    public void paymentProcess(User user) {
        int money = user.getCashMoney() - getAmount();

        if (user.getCashMoney() < getAmount()) {
            System.out.println("금액이 부족합니다. 부족한 금액: " + Math.abs(money) + "원");
            return;
        }
        user.setCashMoney(money);
        System.out.println("현금결제 완료! 잔돈:" + user.getCashMoney());
    }


}
