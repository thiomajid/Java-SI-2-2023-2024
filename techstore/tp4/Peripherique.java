package techstore.tp4;

import techstore.tp3.Article;

public class Peripherique extends Article {
    private String technologieDeConnexion;
    private String interfaceAvecOrdinateur;

    public Peripherique(String nom, double prix, String technologieDeConnexion, String interfaceAvecOrdinateur) {
        super(nom, prix);
        this.technologieDeConnexion = technologieDeConnexion;
        this.interfaceAvecOrdinateur = interfaceAvecOrdinateur;
    }

    public String getTechnologieDeConnexion() {
        return technologieDeConnexion;
    }

    public void setTechnologieDeConnexion(String technologieDeConnexion) {
        this.technologieDeConnexion = technologieDeConnexion;
    }

    public String getInterfaceAvecOrdinateur() {
        return interfaceAvecOrdinateur;
    }

    public void setInterfaceAvecOrdinateur(String interfaceAvecOrdinateur) {
        this.interfaceAvecOrdinateur = interfaceAvecOrdinateur;
    }

    @Override
    public String toString() {
        return super.toString() + ", technologie de connexion=" + this.technologieDeConnexion + ", interface avec ordinateur=" + this.interfaceAvecOrdinateur;
    }
}
