package TP1;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = input.nextLine();

        text = text.toUpperCase();

        System.out.println("\nThe string contains:");

        for (char alphabetLetter = 'A'; alphabetLetter <= 'Z'; alphabetLetter++) {

            int count = 0;

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == alphabetLetter) {
                    count++;
                }
            }

            if (count > 0) {
                System.out.println(count + " occurrences of the letter '" + alphabetLetter + "'");
            }
        }

        input.close();
    }
}