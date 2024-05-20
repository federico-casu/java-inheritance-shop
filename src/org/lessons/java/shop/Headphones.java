package org.lessons.java.shop;

public class Headphones extends Product {

    // ATTRIBUTES
    private String color;
    private boolean connection;

    // CONSTRUCTORS
    Headphones(String name, double price, int vat, String color, boolean connection) {
        super(name, price, vat);
        this.color = color;
        this.connection = connection;
    }

    //METHODS
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getConnection() {
        if (this.connection) {
            return "wireless";
        }
        return "wired";
    }
    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    @Override
    public void printProduct() {
        super.printProduct();
        System.out.print("Color: " + this.getColor() + "\n");
        System.out.print("Connection: " + this.getConnection() + "\n");
    }
}
