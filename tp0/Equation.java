package tp0;

import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ici on peut utiliser des double pour gérer le cas où les coefficients sont
        // des nombres décimaux
        System.out.println("Donner a");
        double a = sc.nextDouble();
        System.out.println("Donner b");
        double b = sc.nextDouble();
        System.out.println("Donner c");
        double c = sc.nextDouble();

        // On calcule le discriminant
        double delta = Math.pow(b, 2) - 4 * a * c;

        // On affiche le résultat
        if (delta < 0) {
            System.out.println("Aucune solution dans R");
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            System.out.println("Une solution dans R : " + x0);
        } else {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.println("Deux solutions dans R : " + x1 + " et " + x2);
        }

        sc.close();
    }
}