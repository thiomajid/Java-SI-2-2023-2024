package techstore;

import techstore.tp3.Stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TechStore {
    private static final ArrayList<String> names = new ArrayList<>(Arrays.asList("Google pixel 7", "Mackbook Air M1", "Disque dur 512GB"));
    private static final ArrayList<Double> prices = new ArrayList<>(Arrays.asList(1000.0, 1500.0, 200.0));
    private static final ArrayList<Long> quantities = new ArrayList<>(Arrays.asList(10L, 5L, 20L));

    public static void main(String[] args) {
        Stock stock = new Stock(names, prices, quantities);
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            do {
                displayMenu();
                choice = scanner.nextInt();
            } while (choice < 0 || choice > 5);

            switch (choice) {
                case 0:
                    createArticle(scanner, stock);
                    break;

                case 1:
                    increaseArticleQuantity(scanner, stock);
                    break;

                case 2:
                    updateArticle(scanner, stock);
                    break;

                case 3:
                    deleteArticle(scanner, stock);
                    break;

                case 4:
                    displayStock(stock);
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("\nSayonara !");
                    break;
            }
        }

        scanner.close();
    }


    private static void displayMenu() {
        System.out.println("0: Ajouter un article\n1: Augmenter la quantité d'un article\n2: Modifier un article\n3: Supprimer un article\n4: Consulter le stock\n5: Quitter");
    }

    private static void createArticle(Scanner scanner, Stock stock) {
        System.out.println("Nom de l'article: ");
        scanner.nextLine(); // free the buffer
        String name = scanner.nextLine();
        System.out.println("Prix de l'article: ");
        double price = scanner.nextDouble();
        System.out.println("Quantité de l'article: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();

        stock.ajouterArticle(name, price, quantity);
    }

    private static void increaseArticleQuantity(Scanner scanner, Stock stock) {
        System.out.println("Référence de l'article: ");
        scanner.nextLine(); // free the buffer
        String reference = scanner.nextLine();

        System.out.println("Quantité à ajouter: ");
        long quantity = scanner.nextLong();

        stock.incrementerQuantiteArticle(reference, quantity);
    }

    private static void updateArticle(Scanner scanner, Stock stock) {
        System.out.println("Référence de l'article: ");
        scanner.nextLine(); // free the buffer

        String reference = scanner.nextLine();

        System.out.println("Nouveau nom de l'article: ");
        String name = scanner.nextLine();

        System.out.println("Nouveau prix de l'article: ");
        double price = scanner.nextDouble();

        System.out.println("Nouvelle quantité de l'article: ");
        long quantity = scanner.nextLong();

        stock.modifierArticle(reference, name, price, quantity);
    }

    private static void deleteArticle(Scanner scanner, Stock stock) {
        System.out.println("Référence de l'article: ");
        scanner.nextLine(); // free the buffer
        String reference = scanner.nextLine();

        stock.supprimerArticle(reference);
    }

    private static void displayStock(Stock stock) {
        System.out.println(stock);
    }


}
