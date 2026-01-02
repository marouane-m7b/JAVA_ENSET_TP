package TP1;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Entrez un verbe du premier groupe : ");
        String verb = input.nextLine().trim();

        if (verb.length() < 3 || !verb.endsWith("er")) {
            System.out.println("Erreur : Ce verbe ne se termine pas par 'er'!");
            input.close();
            return;
        }

        String radical = verb.substring(0, verb.length() - 2);

        System.out.println("➔ je " + radical + "e");
        System.out.println("➔ tu " + radical + "es");
        System.out.println("➔ il/elle " + radical + "e");
        System.out.println("➔ nous " + radical + "ons");
        System.out.println("➔ vous " + radical + "ez");
        System.out.println("➔ ils/elles " + radical + "ent");

        input.close();
    }
}