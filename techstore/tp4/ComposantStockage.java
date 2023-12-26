package techstore.tp4;

import techstore.tp3.Article;

public class ComposantStockage extends Article implements Garantissable {
    private int capacite;


    public ComposantStockage(String nom, double prix, int capacite) {
        super(nom, prix);
        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int garantirAppareil() {
        return capacite <= 500 ? 1 : 2;
    }

    @Override
    public String toString() {
        return "ComposantStockage{" +
                super.toString() +
                "capacite=" + capacite +
                garantirAppareil() + " ans " +
                "} ";
    }
}
