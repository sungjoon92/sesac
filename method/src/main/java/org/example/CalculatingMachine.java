package org.example;

public class CalculatingMachine {
    int num1;
    int num2;

    public CalculatingMachine(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 더하기
    void plus() {
        int result = this.num1 + this.num2;
        System.out.println("계산결과: " + result);
    }

    // 뺴기

    void minus() {
        int result = this.num1 - this.num2;
        System.out.println("계산결과: " + result);
    }

    // 곱하기
    void multiply() {
        int result = this.num1 * this.num2;
        System.out.println("계산결과: " + result);
    }

    // 나누기
    void divide() {
        double result = (double) this.num1 / this.num2;
        System.out.println("계산결과: " + result);
    }

    public double Calculating(int num1, String Chic, int num2) {
        this.num1 = num1;
        this.num2 = num2;

        return switch (Chic) {
            case "+" -> this.num1 + this.num2;
            case "-" -> this.num1 - this.num2;
            case "*" -> this.num1 * this.num2;
            case "/" -> (double) this.num1 / this.num2;
            default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + Chic);
        };
    }
}
