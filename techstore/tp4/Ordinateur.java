package techstore.tp4;

public abstract class Ordinateur extends AppareilInformatique implements Garantissable {
    private long disqueDur;
    private String carteGraphique;

    public Ordinateur(String nom, double prix, double resolutionEcran, String processeur, long ram, SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique) {
        super(nom, prix, resolutionEcran, processeur, ram, systemeExploitation);
        this.disqueDur = disqueDur;
        this.carteGraphique = carteGraphique;
    }

    public abstract int garantirAppareil();

    public long getDisqueDur() {
        return disqueDur;
    }

    public void setDisqueDur(long disqueDur) {
        this.disqueDur = disqueDur;
    }

    public String getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(String carteGraphique) {
        this.carteGraphique = carteGraphique;
    }

    @Override
    public String toString() {
        return "Ordinateur{" + super.toString() + "disqueDur=" + disqueDur + ", carteGraphique='" + carteGraphique + '\'' + "} ";
    }
}

