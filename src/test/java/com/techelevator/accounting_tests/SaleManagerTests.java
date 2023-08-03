package com.techelevator.accounting_tests;

import com.techelevator.accounting.SaleManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class SaleManagerTests {
    SaleManager saleManager;

    @Before
    public void createSaleManager() {
        saleManager = new SaleManager();
    }

    @Test
    public void alternateDiscount_correctly_alternates_discount() {
        Assert.assertFalse(saleManager.isNextItemDiscounted());

        saleManager.alternateDiscount();

        Assert.assertTrue(saleManager.isNextItemDiscounted());

        saleManager.alternateDiscount();

        Assert.assertFalse(saleManager.isNextItemDiscounted());
    }

    @Test
    public void calculatePrice_returns_correct_price_for_one_purchase() {
        BigDecimal price = saleManager.calculatePrice(BigDecimal.valueOf(5));

        Assert.assertEquals(BigDecimal.valueOf(5), price);
    }

    @Test
    public void calculatePrice_returns_correct_price_for_two_purchases() {
        saleManager.calculatePrice(BigDecimal.valueOf(5));

        BigDecimal price = saleManager.calculatePrice(BigDecimal.valueOf(5));

        Assert.assertEquals(
                LocalDate.now().getMonth() == Month.AUGUST
                        ? BigDecimal.valueOf(4)
                        : BigDecimal.valueOf(5)
                , price
        );
    }

    @Test
    public void calculatePrice_returns_correct_price_for_three_purchases() {
        saleManager.calculatePrice(BigDecimal.valueOf(5));

        BigDecimal price1 = saleManager.calculatePrice(BigDecimal.valueOf(5));
        BigDecimal price2 = saleManager.calculatePrice(BigDecimal.valueOf(5));

        Assert.assertEquals(
                LocalDate.now().getMonth() == Month.AUGUST
                        ? BigDecimal.valueOf(4)
                        : BigDecimal.valueOf(5)
                , price1
        );
        Assert.assertEquals(BigDecimal.valueOf(5), price2);
    }
}
