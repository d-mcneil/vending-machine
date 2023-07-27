package com.techelevator.Accounting;

import java.math.BigDecimal;

public class Account
{
    private BigDecimal balance = new BigDecimal(0);
    boolean isNextItemDiscounted = false;

    public BigDecimal getBalance() {
        return balance;
    }

    public void feedMoney(int moneyToAdd) {
        this.balance = this.balance.add(BigDecimal.valueOf(moneyToAdd));
    }

    public void deductFromBalance(BigDecimal moneyToDeduct) {
        this.balance = this.balance.subtract(moneyToDeduct);
    }

    public boolean isNextItemDiscounted() {
        return isNextItemDiscounted;
    }
}
