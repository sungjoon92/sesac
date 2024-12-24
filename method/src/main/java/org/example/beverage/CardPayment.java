package org.example.beverage;

public class CardPayment extends Payment{
    public CardPayment(int amount) {
        super(amount);
    }

    // 카드결제 로직
    @Override
    public void paymentProcess(User user, Drink drink) {
        int money = user.getCardMoney() - drink.getPayment();

        // 잔액 부족할때
        if (user.getCardMoney() < drink.getPayment()) {
            System.out.println("잔액이 부족합니다. 잔액: " + user.getCardMoney());
            return;
        }

        // 구매환료시 음료량 한개 제거, 금액 셋팅
        drink.setStockQuantity(drink.getStockQuantity() - 1);
        user.setCardMoney(money);

        System.out.println("카드결제 완료! 잔액:" + user.getCardMoney());
        System.out.println("남은 음료수량: "+drink.getName() + drink.getStockQuantity()+"개");

    }

}
