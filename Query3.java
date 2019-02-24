package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare simpla
 */
public class Query3 {
    private String nume;
    private String prenume;
    private String strada;

    public Query3(String nume, String prenume, String strada) {
        this.nume = nume;
        this.prenume = prenume;
        this.strada = strada;
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

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }
}
