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

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Sort and display grades");
            System.out.println("2. Display average grade");
            System.out.println("3. Display highest and lowest grades");
            System.out.println("4. Count students with specific grade");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sortAndDisplay(grades);
                    break;
                case 2:
                    displayAverage(grades);
                    break;
                case 3:
                    displayMinMax(grades);
                    break;
                case 4:
                    System.out.print("Enter the grade to search: ");
                    double searchGrade = scanner.nextDouble();
                    countGrade(grades, searchGrade);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

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

    public static void countGrade(double[] grades, double searchGrade) {
        int count = 0;
        for (double grade : grades) {
            if (grade == searchGrade) {
                count++;
            }
        }
        System.out.println("\nNumber of students with grade " + searchGrade + ": " + count);
    }
}