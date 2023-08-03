package com.techelevator.items;

import java.math.BigDecimal;

public interface Vendable {
    String getProductName();

    BigDecimal getPrice();

    String getProductType();

    String getDispenseMessage();
}
