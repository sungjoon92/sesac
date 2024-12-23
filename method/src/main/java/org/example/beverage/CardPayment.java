package org.example.beverage;

public class CardPayment extends Payment{
    public CardPayment(int amount) {
        super(amount);
    }

    // 카드결제 로직
    @Override
    public void paymentProcess(User user) {
        int money = user.getCardMoney() - getAmount();

        if (user.getCardMoney() < getAmount()) {
            System.out.println("잔액이 부족합니다. 잔액: " + user.getCardMoney());
            return;
        }
        user.setCardMoney(money);
        System.out.println("카드결제 완료! 잔액:" + user.getCardMoney());
    }

}
