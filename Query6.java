package sample;

/**
 * Clasa cu ajutorul careia se poate afisa o interogare simpla
 */
public class Query6 {
    private String prenume;
    private String email;
    private String strada;
    private String numar;

    public Query6(String prenume, String email, String strada, String numar) {
        this.prenume = prenume;
        this.email = email;
        this.strada = strada;
        this.numar = numar;
    }

    /**
     * Getters and Setters
     */
    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
