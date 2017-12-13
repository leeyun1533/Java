package testWindowBulider;

import javax.swing.*;
import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private int balance;
    private int cardSpending;
    private int cashSpending;

    Account(String name) {
        this.name = name;
        balance = 0;
        cardSpending = 0;
        cashSpending = 0;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getCardSpending() {
        return cardSpending;
    }

    public int getCashSpending() {
        return cashSpending;
    }


    public int depositMoney(int money) {
        this.balance += money;
        return balance;
    }

    public int spendCard(int money) {
        this.balance -= money;
        this.cardSpending += money;
        return cardSpending;
    }

    public int spendCash(int money) {
        this.balance -= money;
        this.cashSpending += money;
        return cashSpending;
    }

}

