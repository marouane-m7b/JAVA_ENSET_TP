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
        System.out.println("Reversed string: " + reversed);
    }

    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}