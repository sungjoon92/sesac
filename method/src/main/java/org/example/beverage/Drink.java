package org.example.beverage;

public class Drink {
    public String name;
    private int payment;
    private int stockQuantity;


    public Drink(String name, int payment, int stockQuantity) {
        this.name = name;
        this.payment = payment;
        this.stockQuantity = stockQuantity;
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

    @Override
    public String toString() {
        return  "Drink{" +
                "이름 ='" + name + '\'' +
                " 가격 = " + payment +
                " 수량 = " + stockQuantity +
                "}\n";
    }
}

