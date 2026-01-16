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
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                // Check zero here or let divide handle it?
                // divide handles it and prints error.
                double res = divide(a, b);
                // If b was 0, divide printed error. We probably shouldn't print result if 0 was returned due to error.
                // But simplified:
                if (b != 0) {
                    System.out.println("Result: " + res);
                }
                break;
            default:
                System.out.println("Error: Operation '" + op + "' not supported");
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("--- Testing divide ---");
        System.out.println("10 / 2 = " + calc.divide(10, 2));
        System.out.println("10 / 0 = " + calc.divide(10, 0)); // Should print error

        System.out.println("\n--- Testing convertToNumber ---");
        System.out.println("123 -> " + calc.convertToNumber("123"));
        System.out.println("abc -> " + calc.convertToNumber("abc")); // Should print error

        System.out.println("\n--- Testing calculate ---");
        calc.calculate("+", 10, 20);
        calc.calculate("-", 10, 5);
        calc.calculate("*", 5, 5);
        calc.calculate("/", 10, 2);
        calc.calculate("/", 10, 0);
        calc.calculate("^", 2, 3); // Error
    }
}
