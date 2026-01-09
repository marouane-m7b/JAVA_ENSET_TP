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
