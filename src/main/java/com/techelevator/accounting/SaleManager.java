package com.techelevator.accounting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class SaleManager
{
    private boolean isNextItemDiscounted = false;

    public void alternateDiscount()
    {
        isNextItemDiscounted = !isNextItemDiscounted;

    }

    public boolean isNextItemDiscounted() {
        return isNextItemDiscounted;
    }

    public BigDecimal calculatePrice(BigDecimal retailPrice)
    {
        BigDecimal discountedPrice = retailPrice;

        if (LocalDate.now().getMonth() == Month.AUGUST)
        {
            if( isNextItemDiscounted)
            {
               discountedPrice = retailPrice.subtract(BigDecimal.valueOf(1));
            }
            alternateDiscount();
        }
        return discountedPrice;
    }
}
