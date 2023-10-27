package tp0;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operation;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1.Addition\n2.Substraction\n3.Multiplication\n4.Division\n5.Quitter");
            operation = sc.nextInt();

            if (operation == 5) {
                System.out.println("Au revoir !");
                break;
            }

            System.out.println("Entrez le premier nombre :");
            int a = sc.nextInt();

            System.out.println("Entrez le deuxième nombre :");
            int b = sc.nextInt();

            if (operation == 1) {
                System.out.println("Le résultat est : " + add(a, b));
            } else if (operation == 2) {
                System.out.println("Le résultat est : " + substract(a, b));
            } else if (operation == 3) {
                System.out.println("Le résultat est : " + multiply(a, b));
            } else if (operation == 4) {
                System.out.println("Le résultat est : " + divide(a, b));
            } else {
                System.out.println("Veuillez entrer un choix valide.");
            }

        } while (operation != 5);

        sc.close();
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int substract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            return 0;
        }

        return a / b;
    }

}
