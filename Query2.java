package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare simpla
 */
public class Query2 {
    private String numeProdus;
    private String numeCategorie;

    public Query2(String numeProdus, String numeCategorie) {
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
