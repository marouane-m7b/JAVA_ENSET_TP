package TP3_IO_Exceptions.IO.Exercise2;

import java.util.Scanner;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        IProduitMetier metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Product Management (Serialization) ---");
            System.out.println("1. Display products");
            System.out.println("2. Search product by ID");
            System.out.println("3. Add new product");
            System.out.println("4. Delete product by ID");
            System.out.println("5. Save products");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Product> list = metier.getAll();
                    if (list.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    long searchId = scanner.nextLong();
                    Product p = metier.findById(searchId);
                    if (p != null) {
                        System.out.println(p);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    long id = scanner.nextLong();
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
                    
                    metier.add(new Product(id, name, brand, price, desc, stock));
                    System.out.println("Product added to memory (Don't forget to Save!).");
                    break;
                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    long delId = scanner.nextLong();
                    metier.delete(delId);
                    System.out.println("Product deleted from memory.");
                    break;
                case 5:
                    metier.saveAll();
                    System.out.println("Products saved to products.dat.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
