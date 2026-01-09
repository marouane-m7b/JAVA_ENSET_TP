package TP1_Strings_Arrays;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = "";
        int choice;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Enter");
            System.out.println("2. Display");
            System.out.println("3. Reverse");
            System.out.println("4. Number of words");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    text = input.nextLine();
                    System.out.println("String saved successfully!");
                    waitForKey(input);
                    break;

                case 2:
                    if (text.isEmpty()) {
                        System.out.println("No string has been entered yet.");
                    } else {
                        System.out.println("The string is: " + text);
                    }
                    waitForKey(input);
                    break;

                case 3:
                    if (text.isEmpty()) {
                        System.out.println("No string has been entered yet.");
                    } else {
                        String reversed = reverseString(text);
                        System.out.println("Reversed string: " + reversed);
                    }
                    waitForKey(input);
                    break;

                case 4:
                    if (text.isEmpty()) {
                        System.out.println("No string has been entered yet.");
                    } else {
                        int wordCount = countWords(text);
                        System.out.println("Number of words: " + wordCount);
                    }
                    waitForKey(input);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    waitForKey(input);
            }
        } while (choice != 0);

        input.close();
    }

    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public static int countWords(String str) {
        str = str.trim();

        if (str.isEmpty()) {
            return 0;
        }

        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ') {
                inWord = false;
            } else {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            }
        }

        return wordCount;
    }

    public static void waitForKey(Scanner input) {
        System.out.println("\nPress any key to return to the menu.");
        input.nextLine();
    }
}