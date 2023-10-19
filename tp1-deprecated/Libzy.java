import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Libzy {
    // on initialise l'ID à 3 car on a déjà 3 livres dans notre bibliothèque
    // Comme c'est une variable globale, elle est accessible dans toutes les
    // méthodes de la classe
    public static int bookId = 3;

    // Arrays.asList() permet d'initialiser une ArrayList avec des valeurs
    public static ArrayList<Integer> ids = new ArrayList<Integer>(Arrays.asList(0, 1, 2));

    public static ArrayList<Integer> prices = new ArrayList<Integer>(Arrays.asList(12, 25, 15));

    public static ArrayList<String> names = new ArrayList<String>(
            Arrays.asList("Le Petit Prince", "Middle Earth", "Harry Potter et le prisonnier d'Azkaban"));

    public static ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Antoine de Saint-Exupéry",
            "J.R.R. Tolkien", "J.K. Rowling"));

    public static ArrayList<String> references = new ArrayList<String>(
            Arrays.asList("Leirne0", "Mdlat1", "HryPtetlrsnirdAkbn2"));

    public static void main(String[] args) {
        System.out.println("Bienvenue chez Libzy !");

        // Etape 2
        Scanner scanner = new Scanner(System.in);
        int user = -1;

        while ((user != 0) && (user != 1)) {
            System.out.println("0 - Gérant\n1 - Abonné");
            user = scanner.nextInt();

            if ((user != 0) && (user != 1)) {
                System.out.println("Veuillez entrer un choix valide.");
            }
        }

        if (user == 1) {
            System.out.println("Bonjour abonné !\n");
        } else {
            boolean exit = false; // cette variable permet de faire tourner le programme tant que l'utilisateur en
                                  // avis

            while (!exit) {
                System.out.println("0 - Ajouter un ouvrage\n1 - Mettre à jour un ouvrage\n2 - Lister vos ouvrages\n"
                        + "3 - Supprimer un ouvrage\n4 - Quitter");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("Veuillez entrer le titre de l'ouvrage :");
                        scanner.nextLine(); // on vide le scanner pour éviter les problèmes de lecture
                        String title = scanner.nextLine();

                        System.out.println("Veuillez entrer l'auteur de l'ouvrage :");
                        String author = scanner.nextLine();

                        System.out.println("Veuillez entrer le prix de l'ouvrage :");
                        int price = scanner.nextInt();

                        registerItem(title, author, price);
                        displayByPriceAscending();

                        break;
                    case 1:
                        System.out.println("Veuillez entrer la référence de l'ouvrage :");
                        scanner.nextLine(); // on vide le scanner
                        String ref = scanner.nextLine();

                        System.out.println("Veuillez entrer le nouveau prix de l'ouvrage :");
                        int newPrice = scanner.nextInt();

                        updateItem(ref, newPrice);
                        displayByPriceAscending();
                        break;
                    case 2:
                        System.out.println("0 - Tri croissant\n1 - Tri décroissant");
                        int sortOrder = scanner.nextInt();

                        if (sortOrder == 0) {
                            displayByPriceAscending();
                        } else if (sortOrder == 1) {
                            displayByPriceDescending();
                        } else {
                            System.out.println("Veuillez entrer un choix valide.");
                        }
                        break;
                    case 3:
                        System.out.println("Veuillez entrer la référence de l'ouvrage :");
                        scanner.nextLine(); // on vide le scanner
                        String refToDelete = scanner.nextLine();

                        deleteItem(refToDelete);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Bye bye ;-)");
                        break;
                    default:
                        System.out.println("Veuillez entrer un choix valide.");
                        break;
                }
            }
        }

        scanner.close();
    }

    public static String createReference(String bookName, int id) {
        String ref = "";

        // On incrémente l'indice de parcours de 2 à chaque itération
        // comme on sait que l'indice est toujours pair
        for (int idx = 0; idx < bookName.length(); idx += 2) {
            if (!(bookName.charAt(idx) == ' ')) {
                ref += bookName.charAt(idx);
            }
        }

        // On ajoute l'ID
        ref += id;

        return ref;
    }

    public static void registerItem(String name, String author, int price) {
        String bookReference = createReference(name, price);
        ids.add(bookId);
        prices.add(price);
        names.add(name);
        authors.add(author);
        references.add(bookReference);

        bookId++; // On incrémente l'ID pour le prochain livre
    }

    public static void updateItem(String ref, int updatedPrice) {
        // La méthode indexOf retourne l'indice de l'élément recherché s'il existe dans
        // la liste sinon, elle retourne -1
        int bookIndex = references.indexOf(ref);

        if (bookIndex != -1) {
            prices.set(bookIndex, updatedPrice);
        } else {
            System.out.println("La référence n'existe pas.");
        }

    }

    public static void displayByPriceAscending() {
        // Cette liste va contenir les indices des prix triés
        // Avec cette approche, on évite de modifier les listes initiales
        ArrayList<Integer> sortedIndices = new ArrayList<Integer>();

        // On initialise la liste avec les indices de la liste initiale
        for (int idx = 0; idx < prices.size(); idx++) {
            sortedIndices.add(idx);
        }

        // trie croissant
        for (int idx = 0; idx < prices.size(); idx++) {
            for (int jdx = idx + 1; jdx < prices.size(); jdx++) {
                if (prices.get(sortedIndices.get(idx)) > prices.get(sortedIndices.get(jdx))) {
                    int temp = sortedIndices.get(idx);
                    sortedIndices.set(idx, sortedIndices.get(jdx));
                    sortedIndices.set(jdx, temp);
                }
            }
        }

        // On affiche les livres triés
        for (int idx = 0; idx < sortedIndices.size(); idx++) {
            int bookIndex = sortedIndices.get(idx);
            System.out.println("Référence : " + references.get(bookIndex) + "\nTitre : " + names.get(bookIndex)
                    + "\nAuteur : " + authors.get(bookIndex) + "\nPrix : " + prices.get(bookIndex) + "\n");
        }

    }

    public static void displayByPriceDescending() {
        // Cette liste va contenir les indices des prix triés
        // Avec cette approche, on évite de modifier les listes initiales
        ArrayList<Integer> sortedIndices = new ArrayList<Integer>();

        // On initialise la liste avec les indices de la liste initiale
        for (int idx = 0; idx < prices.size(); idx++) {
            sortedIndices.add(idx);
        }

        // trie décroissant
        for (int idx = 0; idx < prices.size(); idx++) {
            for (int jdx = idx + 1; jdx < prices.size(); jdx++) {
                if (prices.get(sortedIndices.get(idx)) < prices.get(sortedIndices.get(jdx))) {
                    int temp = sortedIndices.get(idx);
                    sortedIndices.set(idx, sortedIndices.get(jdx));
                    sortedIndices.set(jdx, temp);
                }
            }
        }

        // On affiche les livres triés
        for (int idx = 0; idx < sortedIndices.size(); idx++) {
            int bookIndex = sortedIndices.get(idx);
            System.out.println("Référence : " + references.get(bookIndex) + "\nTitre : " + names.get(bookIndex)
                    + "\nAuteur : " + authors.get(bookIndex) + "\nPrix : " + prices.get(bookIndex) + "\n");
        }

    }

    public static void deleteItem(String ref) {
        int bookIndex = references.indexOf(ref);

        if (bookIndex != -1) {
            ids.remove(bookIndex);
            prices.remove(bookIndex);
            names.remove(bookIndex);
            authors.remove(bookIndex);
            references.remove(bookIndex);
        } else {
            System.out.println("La référence n'existe pas.");
        }
    }
}