package org.example;

public class Solution {
    public int solution(int totalPrice, String membership, String paymentMethod) {

        double result = totalPrice;

        // 기본 할인
        if (totalPrice > 500000) {
            result = totalPrice * (1 - 0.15);

        } else  if (totalPrice > 300000) {
            result = totalPrice * (1 - 0.1);

        } else if (totalPrice > 10000){
            result = totalPrice * (1 - 0.05);
        }



        // 등급별 할인
        switch (membership){
            case "실버":
                result = result * (1 - 0.03);
                break;
            case "골드" :
                result = result * (1 - 0.05);
                break;
            case "플래티넘" :
                result = result * (1 - 0.10);
                break;
        }

        // 결제 방식 별
        if (paymentMethod.equals("현금")){
            result = result * (1 - 0.02);
        }

        // 특별 프로모션
//            할인 적용 전의 총 구매 금액이 500,000원 이상인 플래티넘 회원이 현금 결제를 하는 경우 50,000원 추가 할인
        if (totalPrice >= 500000 && membership.equals("플래티넘") && paymentMethod.equals("현금")){
            result -= 50000;
        }

        return (int) result;
    }
}
