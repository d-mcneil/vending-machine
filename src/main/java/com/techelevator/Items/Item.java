package com.techelevator.Items;

import java.math.BigDecimal;

public abstract class Item implements Vendable
{
    private String productName;
    private String productType;
    private BigDecimal price;
    private String slotLocation;

    public Item(String productName, String productType, BigDecimal price, String slotLocation)
    {
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.slotLocation = slotLocation;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    // todo: take out if not used
    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    // todo: take out if not used
    @Override
    public String getSlotLocation() {
        return slotLocation;
    }
}
