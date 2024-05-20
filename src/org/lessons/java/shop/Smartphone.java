package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Product {

    // ATTRIBUTES
    private String imei;
    private int memory;

    // CONSTRUCTORS
    Smartphone(String name, double price, int vat, int memory) {
        super(name, price, vat);
        this.imei = generateIMEI();
        this.memory = memory;
    }

    // METHODS
    public String generateIMEI() {
        String imei = "";
        for (int i = 0; i < 15; i++) {
            imei += String.format("%d", new Random().nextInt(10));
        }
        return imei;
    }
    public String getImei() {
        return this.imei;
    }

    public int getMemory() {
        return this.memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public void printProduct() {
        super.printProduct();
        System.out.print("IMEI: " + this.getImei() + "\n");
        System.out.print("Memory: " + this.getMemory() + "\n");
    }

    @Override
    public BigDecimal getDiscountedPrice() {
        if (this.memory < 32) {
            return this.getTotalPrice().multiply(new BigDecimal("0.95"));
        }
        return super.getDiscountedPrice();
    }
}
