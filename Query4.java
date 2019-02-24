package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare simpla
 */
public class Query4 {
    private String numeProdus;
    private String numeCategorie;
    private String durataPreparare;

    public Query4(String numeProdus, String numeCategorie, String durataPreparare) {
        this.numeProdus = numeProdus;
        this.numeCategorie = numeCategorie;
        this.durataPreparare = durataPreparare;
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

    public String getDurataPreparare() {
        return durataPreparare;
    }

    public void setDurataPreparare(String durataPreparare) {
        this.durataPreparare = durataPreparare;
    }
}
