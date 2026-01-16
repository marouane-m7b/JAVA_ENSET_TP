package TP3_IO_Exceptions.Exceptions.Exercise2;

public class Vehicle {
    public Vehicle() {}

    public void testSpeed(int speed) throws TooFastException {
        if (speed > 90) {
            throw new TooFastException(speed);
        }
        System.out.println("Speed " + speed + " is acceptable.");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();

        // Test 1: Good speed
        try {
            System.out.println("Testing speed 80...");
            v.testSpeed(80);
        } catch (TooFastException e) {
            e.printStackTrace();
        }

        // Test 2: Too fast
        try {
            System.out.println("\nTesting speed 120...");
            v.testSpeed(120);
        } catch (TooFastException e) {
            e.printStackTrace();
        }
    }
}
