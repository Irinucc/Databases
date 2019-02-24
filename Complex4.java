package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare complexa
 */
public class Complex4 {
    private String numeProdus;
    private String numeCategorie;

    public Complex4(String numeProdus, String numeCategorie) {
        this.numeProdus = numeProdus;
        this.numeCategorie = numeCategorie;
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
}
