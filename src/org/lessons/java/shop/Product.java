package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Product {

    // ATTRIBUTES
    private int code;
    private String name;
    private String description;
    private BigDecimal price;
    private int vat;

    // CONSTRUCTORS
    Product (String name, double price, int vat) {
        this.code = new Random().nextInt(1, 1000000);
        this.name = name;
        this.price = new BigDecimal(price);
        this.vat = vat;
    }

    // METHODS
    // code
    public String getCode() {
        return String.format("%06d", this.code);
    }

    // name
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // description
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // price
    public BigDecimal getBasePrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    // vat
    public int getVat() {
        return this.vat;
    }
    public void setVat(int vat) {
        this.vat = vat;
    }

    public BigDecimal getTotalPrice() {
        return this.price.add(this.price.multiply(new BigDecimal(this.vat).divide(new BigDecimal("100"))));
//        return (this.price + (this.price * ((double)this.vat / 100)));
    }

    public String getProductName() {
        return String.format("%06d", this.code) + "-" + this.name;
    }

    public void printProduct() {
        System.out.println();
        System.out.print("Codice: " + this.getCode() + "\n");
        System.out.print("Nome: " + this.getName() + "\n");
        System.out.print("Descrizione: " + this.getDescription() + "\n");
        System.out.print("Prezzo base: " + String.format("%.2f", this.getBasePrice()) + "\n");
        System.out.print("Prezzo: " + String.format("%.2f", this.getTotalPrice()) + "\n");
        System.out.print("iva: " + this.getVat() + "\n");
        System.out.print("Nome prodotto: " + this.getProductName() + "\n");
    }

    public BigDecimal getDiscountedPrice() {
        return this.getTotalPrice().multiply(new BigDecimal("0.98"));
    }

}