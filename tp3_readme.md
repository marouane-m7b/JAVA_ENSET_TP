# TP3: Input/Output & Exception Handling

## Table of Contents

* [Part I: Input/Output](#part-i-inputoutput)
    * [Exercise 1: File Explorer (ls command)](#exercise-1-file-explorer)
    * [Exercise 2: Object Serialization](#exercise-2-object-serialization)
* [Part II: Exception Handling](#part-ii-exception-handling)
    * [Exercise 1: Calculator Exceptions](#exercise-1-calculator-exceptions)
    * [Exercise 2: Custom Exception (Speed Limit)](#exercise-2-custom-exception-speed-limit)

---

# Part I: Input/Output

## Exercise 1: File Explorer

### Problem Description
Simulate the "ls" command to list files and directories in a given path.
For each entry, display:
*   Type (`<DIR>` or `<FILE>`)
*   Permissions (Read `r`, Write `w`, Hidden `h`)

### Solution

**FileExplorer.java**
```java
package TP3_IO_Exceptions.IO.Exercise1;

import java.io.File;
import java.util.Scanner;

public class FileExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified path is not a valid directory.");
        } else {
            System.out.println("Listing contents of: " + path);
            File[] files = directory.listFiles();
            
            if (files != null) {
                for (File file : files) {
                    String type = file.isDirectory() ? "<DIR>" : "<FILE>";
                    StringBuilder permissions = new StringBuilder();
                    
                    permissions.append(file.canRead() ? "r" : "-");
                    permissions.append(file.canWrite() ? "w" : "-");
                    permissions.append(file.isHidden() ? "h" : "-");

                    System.out.printf("%s %s %s%n", file.getName(), type, permissions.toString());
                }
            }
        }
        
        scanner.close();
    }
}
```

---

## Exercise 2: Object Serialization

### Problem Description
Manage a list of `Product` objects using serialization to persist data in `products.dat`.
*   **Product**: Implements `Serializable`.
*   **Metier**: Handles CRUD and file I/O (`saveAll`, `getAll`).
*   **Application**: Menu for user interaction.

### Solution

**Product.java**
```java
package TP3_IO_Exceptions.IO.Exercise2;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
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
    // Getters and toString... (omitted for brevity, see source) 
    
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', brand='" + brand + "', price=" + price + "}";
    }
}
```

**IProduitMetier.java**
```java
package TP3_IO_Exceptions.IO.Exercise2;

import java.util.List;

public interface IProduitMetier {
    void add(Product p);
    List<Product> getAll();
    Product findById(long id);
    void delete(long id);
    void saveAll();
}
```

**MetierProduitImpl.java**
```java
package TP3_IO_Exceptions.IO.Exercise2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IProduitMetier {
    private List<Product> products = new ArrayList<>();
    private String fileName = "products.dat";

    public MetierProduitImpl() {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof List) {
                    products = (List<Product>) obj;
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Warning: Could not load existing products. Starting with empty list.");
            }
        }
    }

    @Override
    public void add(Product p) {
        products.add(p);
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

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
        }
    }
}
```

**Application.java**
```java
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
            choice = scanner.nextInt();
            scanner.nextLine();

            // Switch case implementation handling menu options...
            // (See source code for full implementation)
        } while (choice != 6);

        scanner.close();
    }
}
```

---

# Part II: Exception Handling

## Exercise 1: Calculator Exceptions

### Problem Description
Handle specific exceptions in a calculator:
*   Division by zero.
*   Number format errors.
*   Unsupported operations.

### Solution

**Calculator.java**
```java
package TP3_IO_Exceptions.Exceptions.Exercise1;

public class Calculator {
    
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero not possible.");
            return 0; 
        }
        return (double) a / b;
    }

    public int convertToNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + text + "' is not a valid number");
            return 0;
        }
    }

    public void calculate(String op, int a, int b) {
        switch (op) {
            case "+": System.out.println("Result: " + (a + b)); break;
            case "-": System.out.println("Result: " + (a - b)); break;
            case "*": System.out.println("Result: " + (a * b)); break;
            case "/": 
                if (b != 0) System.out.println("Result: " + divide(a, b)); 
                else divide(a, b); // To trigger error message
                break;
            default: System.out.println("Error: Operation '" + op + "' not supported");
        }
    }
    
    // main method for testing...
}
```

---

## Exercise 2: Custom Exception (Speed Limit)

### Problem Description
Create a custom checked exception `TooFastException` and use it in a `Vehicle` class when speed exceeds 90.

### Solution

**TooFastException.java**
```java
package TP3_IO_Exceptions.Exceptions.Exercise2;

public class TooFastException extends Exception {
    public TooFastException(int speed) {
        super("This is an exception of type TooFastException. Speed involved: " + speed);
    }
}
```

**Vehicle.java**
```java
package TP3_IO_Exceptions.Exceptions.Exercise2;

public class Vehicle {
    public void testSpeed(int speed) throws TooFastException {
        if (speed > 90) {
            throw new TooFastException(speed);
        }
        System.out.println("Speed " + speed + " is acceptable.");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        try {
            v.testSpeed(120);
        } catch (TooFastException e) {
            e.printStackTrace();
        }
    }
}
```