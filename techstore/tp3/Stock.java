package techstore.tp3;

import techstore.tp4.*;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Element> articleList;

    public Stock() {
        articleList = new ArrayList<>();
    }

    public Stock(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }

    public Stock(ArrayList<String> names, ArrayList<Double> prices, ArrayList<Long> quantities) {
        articleList = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            articleList.add(new Element(names.get(i), prices.get(i), quantities.get(i)));
        }
    }

    public ArrayList<Element> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }

    public int getArticleNb() {
        ArrayList<String> names = new ArrayList<>();
        for (Element element : articleList) {
            if (!names.contains(element.getNomArticle())) {
                names.add(element.getNomArticle());
            }
        }

        return names.size();
    }

    public void ajouterArticle(Article article, long quantity) {

        articleList.add(new Element(article, quantity));
    }

    public void ajouterArticle(String nom, double prix, long quantity) {
        Article article = new Article(nom, prix);
        ajouterArticle(article, quantity);
    }

    /**
     * Cette méthode ajoute un Périphérique au stock
     *
     * @param nom
     * @param prix
     * @param quantity
     * @param technologieDeConnexion
     * @param interfaceAvecOrdinateur
     */
    public void ajouterArticle(String nom, double prix, long quantity, String technologieDeConnexion, String interfaceAvecOrdinateur) {
        Peripherique peripherique = new Peripherique(nom, prix, technologieDeConnexion, interfaceAvecOrdinateur);
        ajouterArticle(peripherique, quantity);
    }

    /**
     * Cette méthode ajoute un ComposantStockage au stock
     *
     * @param nom
     * @param prix
     * @param quantity
     * @param capacite
     */
    public void ajouterArticle(String nom, double prix, long quantity, int capacite) {
        ComposantStockage composantStockage = new ComposantStockage(nom, prix, capacite);
        ajouterArticle(composantStockage, quantity);
    }


    /**
     * Cette méthode ajoute un OrdinateurPortable au stock
     *
     * @param nom
     * @param prix
     * @param quantity
     * @param resolutionEcran
     * @param processeur
     * @param ram
     * @param systemeExploitation
     * @param disqueDur
     * @param carteGraphique
     * @param capaciteBatterie
     */
    public void ajouterArticle(String nom, double prix, long quantity, double resolutionEcran, String processeur, long ram, SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique, long capaciteBatterie) {
        OrdinateurPortable ordinateurPortable = new OrdinateurPortable(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, capaciteBatterie);
        ajouterArticle(ordinateurPortable, quantity);

    }


    /**
     * Cette méthode ajoute un OrdinateurBureau au stock
     *
     * @param nom
     * @param prix
     * @param quantity
     * @param resolutionEcran
     * @param processeur
     * @param ram
     * @param systemeExploitation
     * @param disqueDur
     * @param carteGraphique
     * @param alimentation
     */
    public void ajouterArticle(String nom, double prix, long quantity, double resolutionEcran, String processeur, long ram, SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique, String alimentation) {
        OrdinateurBureau ordinateurBureau = new OrdinateurBureau(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, alimentation);
        ajouterArticle(ordinateurBureau, quantity);
    }


    /**
     * Cette méthode ajoute un Mobile au stock
     *
     * @param nom
     * @param prix
     * @param quantity
     * @param resolutionEcran
     * @param processeur
     * @param ram
     * @param systemeExploitation
     * @param appareilPhotoArriere
     * @param appareilPhotoFrontal
     * @param nbSim
     * @param capaciteBatterie
     */
    public void ajouterArticle(String nom, double prix, long quantity, double resolutionEcran, String processeur,
                               long ram, SystemeExploitation systemeExploitation, double appareilPhotoArriere, double appareilPhotoFrontal,
                               int nbSim, long capaciteBatterie) {
        Mobile mobile = new Mobile(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, appareilPhotoArriere, appareilPhotoFrontal, nbSim, capaciteBatterie);
        ajouterArticle(mobile, quantity);
    }


    public Element trouverArticle(String reference) {
        for (Element element : articleList) {
            if (element.equals(reference)) {
                return element;
            }
        }
        return null;
    }

    public void modifierArticle(String reference, String updatedName, double updatedPrice, long updatedQuantity) {
        Element element = trouverArticle(reference);
        if (element != null) {
            element.modifier(updatedName, updatedPrice, updatedQuantity);
            System.out.println(element);
        } else {
            System.out.println("Aucun article avec la référence " + reference + " n'a été trouvé.");
        }
    }

    public void supprimerArticle(String reference) {
        Element element = trouverArticle(reference);
        if (element != null) {
            articleList.remove(element);
            System.out.println("L'article " + element.getNomArticle() + " a été supprimé avec succès.");
        } else {
            System.out.println("Aucun article avec la référence " + reference + " n'a été trouvé.");
        }
    }

    public void incrementerQuantiteArticle(String reference, long quantity) {
        Element element = trouverArticle(reference);
        if (element != null) {
            element.incrementerQuantite(quantity);
            System.out.println(element);
        } else {
            System.out.println("Aucun article avec la référence " + reference + " n'a été trouvé.");
        }
    }

    public void decrementerQuantiteArticle(String reference, long quantity) {
        Element element = trouverArticle(reference);
        if (element != null) {
            element.decrementerQuantite(quantity);
        } else {
            System.out.println("Aucun article avec la référence " + reference + " n'a été trouvé.");
        }
    }

    @Override
    public String toString() {
        String result = "Stock(elements=[\n";
        for (Element element : articleList) {
            result += "\t" + element + "\n";
        }

        return result + "])\n";

    }
}
