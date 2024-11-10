package hai702.tp2.demo.model;

public class CarteBancaire {
    private long numero;
    private int cvv;
    private String date_expiration;
    private Client proprietaire_CB;

    public CarteBancaire(long numero, int cvv, String date_expiration, Client proprietaire_CB) {
        this.numero = numero;
        this.cvv = cvv;
        this.date_expiration = date_expiration;
        this.proprietaire_CB = proprietaire_CB;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }

    public Client getProprietaire_CB() {
        return proprietaire_CB;
    }

    public void setProprietaire_CB(Client proprietaire_CB) {
        this.proprietaire_CB = proprietaire_CB;
    }
}
