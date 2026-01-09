package TP2_Collections_Streams_Generics.Collections.Exercise1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagementApp {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1200.0));
        products.add(new Product(2, "Smartphone", 800.0));
        products.add(new Product(3, "Tablet", 400.0));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Product Management ---");
            System.out.println("1. Display products");
            System.out.println("2. Add product");
            System.out.println("3. Delete product by index");
            System.out.println("4. Modify product by index");
            System.out.println("5. Search product by name");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (products.isEmpty()) System.out.println("List is empty.");
                    else products.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    products.add(new Product(id, name, price));
                    System.out.println("Product added.");
                    break;
                case 3:
                    System.out.print("Enter index to delete: ");
                    int delIndex = scanner.nextInt();
                    if (delIndex >= 0 && delIndex < products.size()) {
                        products.remove(delIndex);
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    System.out.print("Enter index to modify: ");
                    int modIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (modIndex >= 0 && modIndex < products.size()) {
                        Product p = products.get(modIndex);
                        System.out.print("New Name (current: " + p.getName() + "): ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) p.setName(newName);
                        
                        System.out.print("New Price (current: " + p.getPrice() + "): ");
                        if (scanner.hasNextDouble()) {
                             p.setPrice(scanner.nextDouble());
                        }
                        System.out.println("Product modified.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for(Product p : products) {
                        if (p.getName().equalsIgnoreCase(searchName)) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No product found.");
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}
