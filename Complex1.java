package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare complexa
 */
public class Complex1 {
    private String numeProdus;
    private String numeCategorie;
    private String pret;

    public Complex1(String numeProdus, String numeCategorie, String pret) {
        this.numeProdus = numeProdus;
        this.numeCategorie = numeCategorie;
        this.pret = pret;
    }

    /**
     * Getters and Setters
     */
    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public String getNumeCategorie() {
        return numeCategorie;
    }

    public void setNumeCategorie(String numeCategorie) {
        this.numeCategorie = numeCategorie;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }
}
