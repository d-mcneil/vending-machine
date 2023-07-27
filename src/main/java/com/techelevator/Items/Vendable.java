package com.techelevator.Items;

import java.math.BigDecimal;

public interface Vendable
{
    String getProductName();
    BigDecimal getPrice();
    String getSlotLocation();
    String getProductType();
    String getDispenseMessage();

}
