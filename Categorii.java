package sample;

/**
 * Clasa cu ajutorul careia se pot face operatii pe tabela categorii din baza de date
 */
public class Categorii {
    private String idCategorii;
    private String numeCategorie;
    private String durataPreparare;

    public Categorii(String idCategorii, String numeCategorie, String durataPreparare) {
        this.idCategorii = idCategorii;
        this.numeCategorie = numeCategorie;
        this.durataPreparare = durataPreparare;
    }

    /**
     * Getters and Setters
     */
    public String getIdCategorii() {
        return idCategorii;
    }

    public void setIdCategorii(String idCategorii) {
        this.idCategorii = idCategorii;
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
