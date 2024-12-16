package org.example.Bank;

public class BankAccount {
    private String password;
    private int balance = 0;

    // 생성자 함수
    public BankAccount(String password) {
        this.password = password;
    }

    // 생성시 비밀번호 체크
    public static boolean validateInitialPassword(String password) {
        if (password.length() >= 4) {
            return true;
        } else {
            System.out.println("4글자 이상 비밀번호를 입력하세요.");
            return false;
        }// if() end
    }// validateInitialPassword() end

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 계좌 생성 (비밀번호 설정)
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // 입금
    // input 입금할 금액 / balance를 키움 / balance를 return
    public void deposit(int amount) {
        // 유효성 검사
    // 패스워드가 틀린지
        if (!validatePassword(password)) {
            System.out.println("비밀번호가 맞지 않습니다.");
            return;
        }// if() end

    // 금액이 0원 이상인지 확인
        if (!validateAmount(amount)) {
            System.out.println("입글 불가 금액임");
            return;
        }// if() end

        balance += amount;
        System.out.println(amount + "원이 입금됨");

    }// deposit() end

    // 출금 (비밀번호 확인 필요)
    // input 출금할 금액, 비밀번호 / 비밀버너호 체크 / 잔액을 balance만큼 줄임 / return void(또는 int)
    public void withdraw(int amount, String password) {
        // 비밀번호 확인
        if (!validatePassword(password)) {
            System.out.println("비밀번호가 맞지 않습니다.");
            return;
        }
        // 유효성 검사
        if (!validateAmount(amount)) {
            System.out.println("출금 불가 금액임");
            return;
        }
        if (amount > balance) {
            System.out.println("출금할 금액이 잔액보다 많습니다. 출금 불가능");
            return;
        }
        balance -= amount;
    }// withdraw() end

    // private boolean validateAmount(int amount, int minAmount) {
    // if (amount > minAmount) {
    // 위의 방식도 고려

    // 잔액 조회 (비밀번호 확인 필요)
    public int getBalance(String password) {
        if (!validatePassword(password)) {
            System.out.println("비밀번호가 맞지 않습니다.");
            //처리 1: 의미 없는 값을 return(대신, typing에 맞춰서)
            return -1;
            //처리 2: 에러 핸들링
        } else {
            System.out.println("계좌의 남은 금액 : " + balance + "원");
            return balance;
        }// if() end
    }// getBalance() end

    // 금액 0원 초과인지 유효성검사
    private boolean validateAmount(int amount) {
        if (amount > 0) {
            return true;
        } else {
            System.out.println("금액이 0원미만입니다.");
            return false;
        }
    }// validateAmount() end

    // 비밀번호가 맞는지 유효성 검사
    private boolean validatePassword(String password) {
        return this.password.equals(password);
    }// validatePassword() end
}// class end
