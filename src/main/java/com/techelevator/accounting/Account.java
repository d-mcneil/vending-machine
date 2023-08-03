package com.techelevator.accounting;

import java.math.BigDecimal;

public class Account
{
    private BigDecimal balance = new BigDecimal(0);
    private final SaleManager saleManager = new SaleManager();


    public BigDecimal getBalance() {
        return balance;
    }

    public void feedMoney(int moneyToAdd) {
        this.balance = this.balance.add(BigDecimal.valueOf(moneyToAdd));
    }

    public BigDecimal deductFromBalance(BigDecimal moneyToDeduct)
    {
        BigDecimal amountToDeduct = saleManager.calculatePrice(moneyToDeduct);
        this.balance = this.balance.subtract(amountToDeduct);
        return amountToDeduct;
    }

    public void setBalanceToZero()
    {
        this.balance = BigDecimal.ZERO;
    }

    public String[] makeChange() {
        int cents = this.balance.multiply(BigDecimal.valueOf(100)).intValue();
        int remainder;

        int quarters = cents / 25;
        remainder = cents % 25;

        int dimes = remainder / 10;
        remainder = remainder % 10;

        int nickels = remainder / 5;

        String[] change = new String[4];
        change[0] = "Your change is:\n";
        change[1] = "Quarters: " + quarters;
        change[2] = "Dimes: " + dimes;
        change[3] = "Nickels: " + nickels;
        return change;
    }
}
