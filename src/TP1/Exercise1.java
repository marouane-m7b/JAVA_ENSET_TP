package TP1;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        double[] grades = new double[n];

        System.out.println("Enter the grades:");
        for (int i = 0; i < n; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        sortAndDisplay(grades);
        displayAverage(grades);
        displayMinMax(grades);

        scanner.close();
    }

    public static void sortAndDisplay(double[] grades) {
        double[] sortedGrades = grades.clone();
        Arrays.sort(sortedGrades);
        System.out.println("\nSorted grades:");
        for (double grade : sortedGrades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    public static void displayAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.length;
        System.out.printf("\nAverage grade: %.2f\n", average);
    }

    public static void displayMinMax(double[] grades) {
        double min = grades[0];
        double max = grades[0];

        for (double grade : grades) {
            if (grade < min) min = grade;
            if (grade > max) max = grade;
        }

        System.out.println("\nHighest grade: " + max);
        System.out.println("Lowest grade: " + min);
    }
}