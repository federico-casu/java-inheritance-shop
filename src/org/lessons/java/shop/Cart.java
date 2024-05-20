package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quanti prodotti vuoi inserire nel carrello?: ");
        Product[] cart = new Product[Integer.parseInt(scanner.nextLine())];
        int productType;
        String name;
        double price;
        int vat;
        boolean fidelityCard;
        BigDecimal total;

        for (int i = 0; i < cart.length; i++) {
            System.out.println("Prodotto n. " + i+1);
            System.out.println("Che tipo di prodotto vuoi aggiungere al carrello?");
            System.out.println("1 - Smartphone");
            System.out.println("2 - Televisore");
            System.out.println("3 - Cuffie");
            System.out.print("Inserisci il numero corrispondente al tipo di prodotto scelto: ");
            productType = Integer.parseInt(scanner.nextLine());

            System.out.print("Nome: ");
            name = scanner.nextLine();
            System.out.print("Prezzo: ");
            price = Double.parseDouble(scanner.nextLine());
            System.out.print("IVA: ");
            vat = Integer.parseInt(scanner.nextLine());

            switch (productType) {
                case 1:
                    int memory;

                    System.out.print("Quanta memoria ha lo smartphone?(Gb): ");
                    memory = Integer.parseInt(scanner.nextLine());

                    cart[i] = new Smartphone(name, price, vat, memory);
                    break;
                case 2:
                    int inch;
                    boolean smart;

                    System.out.println("Quanti pollici ha il televisore?: ");
                    inch = Integer.parseInt(scanner.nextLine());
                    System.out.println("Il televisore é smart? (y/n): ");
                    smart = scanner.nextLine().equals("y");

                    cart[i] = new Television(name, price, vat, inch, smart);
                    break;
                case 3:
                    String color;
                    boolean connection;

                    System.out.println("Di che colore sono le cuffie?: ");
                    color = scanner.nextLine();
                    System.out.println("Le cuffie sono wireless? (y/n): ");
                    connection = scanner.nextLine().equals("y");

                    cart[i] = new Headphones(name, price, vat, color, connection);
                    break;
            }
        }

        System.out.println("Carrello:");
        for (int i = 0; i < cart.length; i++) {
            System.out.println();
            cart[i].printProduct();
        }

        System.out.println("Possiedi una carta fedeltà? (y/n): ");
        fidelityCard = scanner.nextLine().equals("y");

        System.out.println("Totale del carrello");
        if (fidelityCard) {
            total = cart[0].getDiscountedPrice();
            for (int i = 1; i < cart.length; i++) {
                total = total.add(cart[i].getDiscountedPrice()).setScale(2, RoundingMode.HALF_EVEN);
            }
        } else {
            total = cart[0].getTotalPrice();
            for (int i = 1; i < cart.length; i++) {
                total = total.add(cart[i].getTotalPrice()).setScale(2, RoundingMode.HALF_EVEN);
            }
        }

        System.out.println(total + " $");

        scanner.close();
    }
}
