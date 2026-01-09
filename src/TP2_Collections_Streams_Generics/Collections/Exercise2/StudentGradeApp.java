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
