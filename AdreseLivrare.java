package sample;

/**
 * Clasa cu ajutorul careia se pot face operatii pe tabela adreselivrare din baza de date
 */
public class AdreseLivrare {
    private String idAdreseLivrare;
    private String strada;
    private String numar;
    private String bloc;
    private String scara;
    private String etaj;
    private String apartament;

    public AdreseLivrare(String idAdreseLivrare, String strada, String numar, String bloc, String scara, String etaj, String apartament) {
        this.idAdreseLivrare = idAdreseLivrare;
        this.strada = strada;
        this.numar = numar;
        this.bloc = bloc;
        this.scara = scara;
        this.etaj = etaj;
        this.apartament = apartament;
    }

    /**
     * Getters and Setters
     */
    public String getIdAdreseLivrare() {
        return idAdreseLivrare;
    }

    public void setIdAdreseLivrare(String idAdreseLivrare) {
        this.idAdreseLivrare = idAdreseLivrare;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    public String getScara() {
        return scara;
    }

    public void setScara(String scara) {
        this.scara = scara;
    }

    public String getEtaj() {
        return etaj;
    }

    public void setEtaj(String etaj) {
        this.etaj = etaj;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }
}
