package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare simpla
 */
public class Query5 {
    private String status;
    private String nume;
    private String prenume;

    public Query5(String status, String nume, String prenume) {
        this.status = status;
        this.nume = nume;
        this.prenume = prenume;
    }

    /**
     * Getters and Setters
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
}
