package org.lessons.java.shop;

import java.math.BigDecimal;
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

        for (int i = 0; i < cart.length; i++) {
            System.out.println("Prodotto n. " + i);
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

        for (int i = 0; i < cart.length; i++) {
            System.out.println();
            cart[i].printProduct();
        }

        scanner.close();
    }
}
