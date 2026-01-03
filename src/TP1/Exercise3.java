package TP1;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = "";

        System.out.print("Enter a string: ");
        text = input.nextLine();
        System.out.println("String saved successfully!\n");

        System.out.println("The string is: " + text + "\n");

        String reversed = reverseString(text);
        System.out.println("Reversed string: " + reversed + "\n");

        int wordCount = countWords(text);
        System.out.println("Number of words: " + wordCount);
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
}