package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare simpla
 */
public class Query1 {
    private String nume;
    private String prenume;
    private String timpLivrare;

    public Query1(String nume, String prenume, String timpLivrare) {
        this.nume = nume;
        this.prenume = prenume;
        this.timpLivrare = timpLivrare;
    }

    /**
     * Getters and Setters
     */
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTimpLivrare() {
        return timpLivrare;
    }

    public void setTimpLivrare(String timpLivrare) {
        this.timpLivrare = timpLivrare;
    }
}
