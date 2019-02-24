package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare complexa
 */
public class Complex2 {
    private String numeCategorie;
    private String numarProduse;

    public Complex2(String numeCategorie, String numarProduse) {
        this.numeCategorie = numeCategorie;
        this.numarProduse = numarProduse;
    }

    /**
     * Getters and Setters
     */
    public String getNumeCategorie() {
        return numeCategorie;
    }

    public void setNumeCategorie(String numeCategorie) {
        this.numeCategorie = numeCategorie;
    }

    public String getNumarProduse() {
        return numarProduse;
    }

    public void setNumarProduse(String numarProduse) {
        this.numarProduse = numarProduse;
    }
}
