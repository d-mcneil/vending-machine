package com.techelevator.AccountingTests;

import com.techelevator.accounting.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountTests {
    Account account;

    @Before
    public void createAccount() {
        account = new Account();
    }

    // ****************************************
    // ***** makeChange tests
    // ****************************************

    @Test
    public void makeChange_provides_correct_change_in_quarters_dimes_and_nickels_for_90_cents(){
        account.feedMoney(5);
        account.deductFromBalance(BigDecimal.valueOf(4.10));

        String[] change = account.makeChange();

        Assert.assertEquals("Your change is:\n", change[0]);
        Assert.assertEquals("Quarters: 3", change[1]);
        Assert.assertEquals("Dimes: 1", change[2]);
        Assert.assertEquals("Nickels: 1", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_and_dimes_for_3_dollars_and_70_cents(){
        account.feedMoney(5);
        account.deductFromBalance(BigDecimal.valueOf(1.30));

        String[] change = account.makeChange();

        Assert.assertEquals("Your change is:\n", change[0]);
        Assert.assertEquals("Quarters: 14", change[1]);
        Assert.assertEquals("Dimes: 2", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_for_20_dollars(){
        account.feedMoney(20);

        String[] change = account.makeChange();

        Assert.assertEquals("Your change is:\n", change[0]);
        Assert.assertEquals("Quarters: 80", change[1]);
        Assert.assertEquals("Dimes: 0", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_for_empty_account(){
        String[] change = account.makeChange();

        Assert.assertEquals("Your change is:\n", change[0]);
        Assert.assertEquals("Quarters: 0", change[1]);
        Assert.assertEquals("Dimes: 0", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_for_negative_20_dollars(){
        account.feedMoney(-20);

        String[] change = account.makeChange();

        Assert.assertEquals("Your change is:\n", change[0]);
        Assert.assertEquals("Quarters: -80", change[1]);
        Assert.assertEquals("Dimes: 0", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_dimes_and_nickels_for_negative_90_cents(){
        account.feedMoney(-5);
        account.deductFromBalance(BigDecimal.valueOf(-4.10));

        String[] change = account.makeChange();

        Assert.assertEquals("Your change is:\n", change[0]);
        Assert.assertEquals("Quarters: -3", change[1]);
        Assert.assertEquals("Dimes: -1", change[2]);
        Assert.assertEquals("Nickels: -1", change[3]);
    }

    // ****************************************
    // ***** feedMoney tests
    // ****************************************

    @Test
    public void feedMoney_adds_correct_amount_of_money_to_balance_when_input_is_correct(){
        account.feedMoney(10);

        Assert.assertEquals(BigDecimal.valueOf(10),account.getBalance());
    }

    @Test
    public void feedMoney_adds_correct_amount_of_money_to_balance_even_though_amount_is_incorrectly_negative(){
        account.feedMoney(-5);

        Assert.assertEquals(BigDecimal.valueOf(-5),account.getBalance());
    }

    @Test
    public void feedMoney_adds_correct_amount_of_money_to_balance_even_though_amount_is_incorrectly_zero(){
        account.feedMoney(0);

        Assert.assertEquals(BigDecimal.valueOf(0),account.getBalance());
    }

    // ****************************************
    // ***** deductFromBalance tests
    // ****************************************

    @Test
    public void deductFromBalance_deducts_correct_amount_from_account_balance() {
        account.feedMoney(10);
        account.deductFromBalance(BigDecimal.valueOf(5.5));

        Assert.assertEquals(BigDecimal.valueOf(4.50), account.getBalance());
    }

    @Test
    public void deductFromBalance_returns_amount_deducted() {
        account.feedMoney(10);
        BigDecimal amountDeducted = account.deductFromBalance(BigDecimal.valueOf(5.5));

        Assert.assertEquals(BigDecimal.valueOf(5.50), amountDeducted);
    }

    @Test
    public void deductFromBalance_deducts_correct_amount_from_account_balance_even_though_amount_is_incorrectly_zero() {
        account.feedMoney(10);
        account.deductFromBalance(BigDecimal.valueOf(0.00));

        Assert.assertEquals(BigDecimal.valueOf(10.00), account.getBalance());
    }

    @Test
    public void deductFromBalance_deducts_correct_amount_from_account_balance_even_though_amount_is_incorrectly_negative() {
        account.feedMoney(10);
        account.deductFromBalance(BigDecimal.valueOf(-5.5));

        Assert.assertEquals(BigDecimal.valueOf(15.50), account.getBalance());
    }

    // ****************************************
    // ***** setBalanceToZero tests
    // ****************************************

    @Test
    public void setBalanceToZero_correctly_sets_account_balance_to_zero() {
        account.feedMoney(10);
        account.setBalanceToZero();

        Assert.assertEquals(BigDecimal.valueOf(0), account.getBalance());
    }

    @Test
    public void setBalanceToZero_correctly_sets_account_balance_to_zero_when_balance_is_already_zero() {
        account.setBalanceToZero();

        Assert.assertEquals(BigDecimal.valueOf(0), account.getBalance());
    }

}
