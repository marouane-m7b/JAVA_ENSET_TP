package TP2_Collections_Streams_Generics.Generics.Exercise2;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Pre-populate for testing
        metier.add(new Product(1, "Laptop", "Dell", 1200.0, "Work station", 10));
        metier.add(new Product(2, "Mouse", "Logitech", 25.0, "Wireless", 50));

        do {
            System.out.println("\n--- Product Management (Generics) ---");
            System.out.println("1. Display list");
            System.out.println("2. Search by ID");
            System.out.println("3. Add new product");
            System.out.println("4. Delete by ID");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (metier.getAll().isEmpty()) System.out.println("No products.");
                    else metier.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    long id = scanner.nextLong();
                    Product p = metier.findById(id);
                    if (p != null) System.out.println(p);
                    else System.out.println("Product not found.");
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    long newId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter Stock: ");
                    int stock = scanner.nextInt();
                    
                    metier.add(new Product(newId, name, brand, price, desc, stock));
                    System.out.println("Product added.");
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    long delId = scanner.nextLong();
                    metier.delete(delId);
                    System.out.println("Operation completed.");
                    break;
                case 5:
                    System.out.println("Bye.");
                    break;
                default:
                    System.out.println("Invalid.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
