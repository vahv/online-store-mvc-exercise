package com.victorherrera.onlinestoremvcexercise.model;

public class CartItem {
    private Long itemId;
    private Laptop laptop;
    private Double priceUnit;
    private Integer quantity;
    private Double subtotal;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal() {
        this.subtotal = this.quantity* this.priceUnit;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
