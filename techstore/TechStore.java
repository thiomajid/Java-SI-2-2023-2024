package techstore;

import techstore.tp3.Stock;
import techstore.tp4.*;

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
                case 0 -> createArticle(scanner, stock);
                case 1 -> increaseArticleQuantity(scanner, stock);
                case 2 -> updateArticle(scanner, stock);
                case 3 -> deleteArticle(scanner, stock);
                case 4 -> displayStock(stock);
                case 5 -> {
                    isRunning = false;
                    System.out.println("\nSayonara !");
                }
            }
        }

        scanner.close();
    }


    private static void displayMenu() {
        System.out.println("0: Ajouter un article\n1: Augmenter la quantité d'un article\n2: Modifier un article\n3: Supprimer un article\n4: Consulter le stock\n5: Quitter");
    }


    private static void createArticle(Scanner scanner, Stock stock) {
        System.out.println("1 - Ordinateur de bureau\n2 - Ordinateur portable\n3 - Mobile\n4 - Composant de stockage\n5 - Périphérique");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> createDesktopComputer(scanner, stock);
            case 2 -> createLaptop(scanner, stock);
            case 3 -> createMobile(scanner, stock);
            case 4 -> createStorageComponent(scanner, stock);
            case 5 -> createPeripherique(scanner, stock);
        }
    }

    private static SystemeExploitation chooseOperatingSystem(Scanner scanner) {
        System.out.println("Système d'exploitation: ");
        System.out.println("1 - FreeDos\n2 - Windows\n3 - Ubuntu\n4 - Android\n5 - iOS");
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> SystemeExploitation.FREEDOS;
            case 2 -> SystemeExploitation.WINDOWS;
            case 3 -> SystemeExploitation.UBUNTU;
            case 4 -> SystemeExploitation.ANDROID;
            case 5 -> SystemeExploitation.IOS;
            default -> null;
        };
    }

    private static void createDesktopComputer(Scanner scanner, Stock stock) {
        System.out.println("Nom de l'ordinateur: ");
        scanner.nextLine(); // free the buffer
        String name = scanner.nextLine();
        System.out.println("Prix de l'ordinateur: ");
        double price = scanner.nextDouble();
        System.out.println("Quantité de l'ordinateur: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Résolution de l'écran: ");
        double resolutionEcran = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Processeur: ");
        String processeur = scanner.nextLine();

        SystemeExploitation systemeExploitation = chooseOperatingSystem(scanner);

        System.out.println("RAM: ");
        long ram = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Disque dur: ");
        long disqueDur = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Carte graphique: ");
        String carteGraphique = scanner.nextLine();

        System.out.println("Alimentation: ");
        String alimentation = scanner.nextLine();

        OrdinateurBureau ordinateurBureau = new OrdinateurBureau(name, price, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, alimentation);
        stock.ajouterArticle(ordinateurBureau, quantity);
    }


    private static void createMobile(Scanner scanner, Stock stock) {
        System.out.println("Nom du mobile: ");
        scanner.nextLine(); // free the buffer
        String name = scanner.nextLine();
        System.out.println("Prix du mobile: ");
        double price = scanner.nextDouble();
        System.out.println("Quantité du mobile: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Résolution de l'écran: ");
        double resolutionEcran = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Processeur: ");
        String processeur = scanner.nextLine();

        SystemeExploitation systemeExploitation = chooseOperatingSystem(scanner);

        System.out.println("RAM: ");
        long ram = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Appareil photo arrière: ");
        double appareilPhotoArriere = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Appareil photo frontal: ");
        double appareilPhotoFrontal = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nombre de SIM: ");
        int nbSim = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Capacité de la batterie: ");
        long capaciteBatterie = scanner.nextLong();
        scanner.nextLine();

        Mobile mobile = new Mobile(name, price, resolutionEcran, processeur, ram, systemeExploitation, appareilPhotoArriere, appareilPhotoFrontal, nbSim, capaciteBatterie);
        stock.ajouterArticle(mobile, quantity);
    }


    private static void createLaptop(Scanner scanner, Stock stock) {
        System.out.println("Nom de l'ordinateur portable: ");
        scanner.nextLine(); // free the buffer
        String name = scanner.nextLine();
        System.out.println("Prix de l'ordinateur portable: ");
        double price = scanner.nextDouble();
        System.out.println("Quantité de l'ordinateur portable: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Résolution de l'écran: ");
        double resolutionEcran = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Processeur: ");
        String processeur = scanner.nextLine();

        SystemeExploitation systemeExploitation = chooseOperatingSystem(scanner);

        System.out.println("RAM: ");
        long ram = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Disque dur: ");
        long disqueDur = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Carte graphique: ");
        String carteGraphique = scanner.nextLine();

        System.out.println("Capacité de la batterie: ");
        long capaciteBatterie = scanner.nextLong();
        scanner.nextLine();

        OrdinateurPortable ordinateurPortable = new OrdinateurPortable(name, price, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, capaciteBatterie);
        stock.ajouterArticle(ordinateurPortable, quantity);
    }

    private static void createStorageComponent(Scanner scanner, Stock stock) {
        System.out.println("Nom du composant: ");
        scanner.nextLine(); // free the buffer
        String name = scanner.nextLine();
        System.out.println("Prix du composant: ");
        double price = scanner.nextDouble();
        System.out.println("Quantité du composant: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Capacité de stockage: ");
        int capaciteStockage = scanner.nextInt();

        ComposantStockage composantStockage = new ComposantStockage(name, price, capaciteStockage);
        stock.ajouterArticle(composantStockage, quantity);
    }

    private static void createPeripherique(Scanner scanner, Stock stock) {
        System.out.println("Nom du périphérique: ");
        scanner.nextLine(); // free the buffer
        String name = scanner.nextLine();
        System.out.println("Prix du périphérique: ");
        double price = scanner.nextDouble();
        System.out.println("Quantité du périphérique: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Technologie de connexion: ");
        String technologieDeConnexion = scanner.nextLine();

        System.out.println("Interface avec l'ordinateur: ");
        String interfaceAvecOrdinateur = scanner.nextLine();

        Peripherique peripherique = new Peripherique(name, price, technologieDeConnexion, interfaceAvecOrdinateur);
        stock.ajouterArticle(peripherique, quantity);
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
