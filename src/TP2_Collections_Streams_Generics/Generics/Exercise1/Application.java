package TP2_Collections_Streams_Generics.Generics.Exercise1;

public class Application {
    public static void main(String[] args) {
        // Test with Integer
        System.out.println("--- Integer Storage ---");
        GenericStorage<Integer> intStorage = new GenericStorage<>();
        intStorage.addElement(10);
        intStorage.addElement(20);
        intStorage.addElement(30);
        System.out.println("Size: " + intStorage.getSize());
        System.out.println("Element at 1: " + intStorage.getElement(1));
        intStorage.removeElement(0);
        System.out.println("After remove(0), Element at 0: " + intStorage.getElement(0));

        // Test with String
        System.out.println("\n--- String Storage ---");
        GenericStorage<String> strStorage = new GenericStorage<>();
        strStorage.addElement("Hello");
        strStorage.addElement("World");
        System.out.println("Size: " + strStorage.getSize());
        System.out.println("Element at 1: " + strStorage.getElement(1));
    }
}
