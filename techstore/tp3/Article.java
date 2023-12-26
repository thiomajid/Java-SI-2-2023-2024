package techstore.tp3;

public class Article {
    private static int nextId = 1;
    private int id;
    private String nom;
    private String reference;
    private double prix;

    public Article(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.id = nextId++;
        this.reference = createReference();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    private String createReference() {
        String ref = "";

        for (int i = 0; i < nom.length(); i = i + 5) {
            if (nom.charAt(i) != ' ') {
                ref += nom.charAt(i);
            }
        }
        ref += id;
        return ref;
    }

    public void modifier(String updatedName) {
        nom = updatedName;
        reference = createReference();
    }

    public void modifier(String updatedName, double updatedPrice) {
        modifier(updatedName);
        prix = updatedPrice;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Article)) {
            return false;
        }

        Article other = (Article) obj;

        return id == other.id && nom.equals(other.nom) && reference.equals(other.reference) && prix == other.prix;
    }
}
