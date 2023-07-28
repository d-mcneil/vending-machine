package com.techelevator.Accounting;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public String[] makeChange() {
        int cents = this.balance.multiply(BigDecimal.valueOf(100)).intValue();
        int remainder;

        int quarters = cents / 25;
        remainder = cents % 25;

        int dimes = remainder / 10;
        remainder = remainder % 10;

        int nickels = remainder / 5;

        String[] change = new String[3];
        change[0] = "Quarters: " + quarters;
        change[1] = "Dimes: " + dimes;
        change[2] = "Nickels: " + nickels;
        return change;
    }
}
