package com.techelevator.Items;

import java.math.BigDecimal;

public abstract class Item implements Vendable
{
    private final String productName;
    private final String productType;
    private final BigDecimal price;

    public Item(String productName, String productType, BigDecimal price)
    {
        this.productName = productName;
        this.productType = productType;
        this.price = price;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
