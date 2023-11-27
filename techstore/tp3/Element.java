package techstore.tp3;

public class Element {
    private Article article;
    private long quantite;

    public Element(Article article, long quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public Element(String nom, double prix, long quantite) {
        this.article = new Article(nom, prix);
        this.quantite = quantite;
    }

    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    public String getReferenceArticle() {
        return article.getReference();
    }

    public String getNomArticle() {
        return article.getNom();
    }

    public double getPrixArticle() {
        return article.getPrix();
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void incrementerQuantite(long q) {
        quantite += q;
    }

    public void decrementerQuantite(long q) {
        quantite -= q;
    }

    public void modifier(String updatedName, double updatedPrice, long updatedQuantity) {
        article = new Article(updatedName, updatedPrice);
        quantite = updatedQuantity;
    }

    public boolean equals(String reference) {
        return article.getReference().equals(reference);
    }

    public boolean equals(Article article) {
        return this.article.equals(article);
    }

    @Override
    public String toString() {
        return "Element(article=" + article + ", quantite=" + quantite + ")";
    }
}
