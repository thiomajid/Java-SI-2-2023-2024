package techstore.tp4;

public class OrdinateurBureau extends Ordinateur {
    private String alimentation;

    public OrdinateurBureau(String nom, double prix, double resolutionEcran, String processeur, long ram, SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique, String alimentation) {
        super(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique);
        this.alimentation = alimentation;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(String alimentation) {
        this.alimentation = alimentation;
    }

    public int garantirAppareil() {
        return 1;
    }

    @Override
    public String toString() {
        return "OrdinateurBureau{" + super.toString() + "alimentation='" + alimentation + garantirAppareil() + " ans " + "} ";
    }
}
