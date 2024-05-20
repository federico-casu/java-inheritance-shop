package org.lessons.java.shop;

import java.math.BigDecimal;

public class Television extends Product {

    // ATTRIBUTES
    private int inch;
    private boolean smart;

    // CONSTRUCTORS
    Television (String name, double price, int vat, int inch, boolean smart) {
        super(name, price, vat);
        this.inch =  inch;
        this.smart = smart;
    }

    // METHODS
    public int getInch() {
        return this.inch;
    }
    public void setInch(int inch) {
        this.inch = inch;
    }

    public String getSmart() {
        if (this.smart) {
            return "Yes";
        }
        return "No";
    }
    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    @Override
    public void printProduct() {
        super.printProduct();
        System.out.print("Inch: " + this.getInch() + "\n");
        System.out.print("Smart: " + this.getSmart() + "\n");
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        if (!this.smart) {
            return this.getTotalPrice().multiply(new BigDecimal("0.90"));
        }
        return super.getDiscountedPrice();
    }
}
