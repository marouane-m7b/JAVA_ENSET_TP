# TP2: Collections & Streams and Generics

## Table of Contents

* [Part I: Collections & Streams](#part-i-collections--streams)
    * [Exercise 1: Lists (Product Management)](#exercise-1-lists)
    * [Exercise 2: Maps (Student Grades)](#exercise-2-maps)
    * [Exercise 3: Sets (Student Groups)](#exercise-3-sets)
* [Part II: Generics](#part-ii-generics)
    * [Exercise 1: Generic Storage](#exercise-1-generic-storage)
    * [Exercise 2: Generic Product Management](#exercise-2-generic-product-management)

---

# Part I: Collections & Streams

## Exercise 1: Lists

### Problem Description
Create a simple application to manipulate a list of product objects.
1.  Create a `Product` class (id, name, price).
2.  Create a `ProductManagementApp` with a main method.
3.  Use an `ArrayList` to perform CRUD operations (Add, Delete by index, Display, Modify by index, Search by name).

### Solution

**Product.java**
```java
package TP2_Collections_Streams_Generics.Collections.Exercise1;

public class Product {
    private long id;
    private String name;
    private double price;

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}
```

**ProductManagementApp.java**
```java
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
                    products.stream()
                            .filter(p -> p.getName().equalsIgnoreCase(searchName))
                            .forEach(System.out::println);
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
```

---

## Exercise 2: Maps

### Problem Description
Create a `HashMap` to store student grades (Key: Name, Value: Grade).
Operations: Insert, Increase grade, Delete grade, Size, Stats (Avg/Max/Min), Check for grade 20.

### Solution

**StudentGradeApp.java**
```java
package TP2_Collections_Streams_Generics.Collections.Exercise2;

import java.util.HashMap;
import java.util.Map;

public class StudentGradeApp {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();

        // 1. Insert student grades
        grades.put("Alice", 15.5);
        grades.put("Bob", 12.0);
        grades.put("Charlie", 18.0);
        grades.put("Diana", 19.5);
        
        System.out.println("Initial grades:");
        grades.forEach((k, v) -> System.out.println(k + ": " + v));

        // 2. Increase a student's grade (e.g., Alice + 1.0)
        grades.computeIfPresent("Alice", (k, v) -> v + 1.0);
        System.out.println("\nAfter increasing Alice's grade:");
        grades.forEach((k, v) -> System.out.println(k + ": " + v));

        // 3. Delete a student's grade (e.g., Bob)
        grades.remove("Bob");
        System.out.println("\nAfter removing Bob:");
        grades.forEach((k, v) -> System.out.println(k + ": " + v));

        // 4. Size
        System.out.println("\nSize of map: " + grades.size());

        // 5. Avg, Max, Min
        double avg = grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double max = grades.values().stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        double min = grades.values().stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        
        System.out.printf("Average: %.2f, Max: %.2f, Min: %.2f\n", avg, max, min);

        // 6. Check if grade 20 exists
        boolean has20 = grades.containsValue(20.0);
        System.out.println("Is there a grade equal to 20? " + has20);
    }
}
```

---

## Exercise 3: Sets

### Problem Description
Create two `HashSet` groups (A and B) with student names.
Operations: Add names, Display Intersection, Display Union.

### Solution

**GroupOperationsApp.java**
```java
package TP2_Collections_Streams_Generics.Collections.Exercise3;

import java.util.HashSet;
import java.util.Set;

public class GroupOperationsApp {
    public static void main(String[] args) {
        Set<String> groupA = new HashSet<>();
        Set<String> groupB = new HashSet<>();

        // 1. Add names
        groupA.add("Ahmed");
        groupA.add("Sarah");
        groupA.add("Leila");
        
        groupB.add("Sarah");
        groupB.add("Kamal");
        groupB.add("Leila");
        groupB.add("Youssef");

        System.out.println("Group A: " + groupA);
        System.out.println("Group B: " + groupB);

        // 2. Intersection
        Set<String> intersection = new HashSet<>(groupA);
        intersection.retainAll(groupB);
        System.out.println("Intersection: " + intersection);

        // 3. Union
        Set<String> union = new HashSet<>(groupA);
        union.addAll(groupB);
        System.out.println("Union: " + union);
    }
}
```

---

# Part II: Generics

## Exercise 1: Generic Storage

### Problem Description
Create a generic class `GenericStorage<T>` to store elements of any type.
Methods: Add, Remove by index, Get by index, Get size.

### Solution

**GenericStorage.java**
```java
package TP2_Collections_Streams_Generics.Generics.Exercise1;

import java.util.ArrayList;
import java.util.List;

public class GenericStorage<T> {
    private List<T> elements = new ArrayList<>();

    public void addElement(T o) {
        elements.add(o);
    }

    public void removeElement(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
        }
    }

    public T getElement(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }

    public int getSize() {
        return elements.size();
    }
}
```

**Application.java**
```java
package TP2_Collections_Streams_Generics.Generics.Exercise1;

public class Application {
    public static void main(String[] args) {
        // Test with Integer
        System.out.println("--- Integer Storage ---");
        GenericStorage<Integer> intStorage = new GenericStorage<>();
        intStorage.addElement(10);
        intStorage.addElement(20);
        intStorage.addElement(30);
        System.out.println("Size: " + intStorage.getSize());
        System.out.println("Element at 1: " + intStorage.getElement(1));
        intStorage.removeElement(0);
        System.out.println("After remove(0), Element at 0: " + intStorage.getElement(0));

        // Test with String
        System.out.println("\n--- String Storage ---");
        GenericStorage<String> strStorage = new GenericStorage<>();
        strStorage.addElement("Hello");
        strStorage.addElement("World");
        System.out.println("Size: " + strStorage.getSize());
        System.out.println("Element at 1: " + strStorage.getElement(1));
    }
}
```

---

## Exercise 2: Generic Product Management

### Problem Description
Use generics to manage a collection of products.
1.  `Product` class (id, name, brand, price, description, stock).
2.  Generic Interface `IMetier<T>` (add, getAll, findById, delete).
3.  Implementation `MetierProduitImpl` for `Product`.
4.  Menu-driven `Application`.

### Solution

**Product.java**
```java
package TP2_Collections_Streams_Generics.Generics.Exercise2;

public class Product {
    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stock;

    public Product(long id, String name, String brand, double price, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }
    
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', brand='" + brand + "', price=" + price + ", desc='" + description + "', stock=" + stock + "}";
    }
}
```

**IMetier.java**
```java
package TP2_Collections_Streams_Generics.Generics.Exercise2;

import java.util.List;

public interface IMetier<T> {
    void add(T o);
    List<T> getAll();
    T findById(long id);
    void delete(long id);
}
```

**MetierProduitImpl.java**
```java
package TP2_Collections_Streams_Generics.Generics.Exercise2;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Product> {
    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product o) {
        products.add(o);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findById(long id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        products.removeIf(p -> p.getId() == id);
    }
}
```

**Application.java**
```java
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
```