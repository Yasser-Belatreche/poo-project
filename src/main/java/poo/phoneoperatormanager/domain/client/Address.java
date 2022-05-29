package poo.phoneoperatormanager.domain.client;

public class Address {
    private String wilaya;
    private String commun;
    
    public Address(String wilaya, String commun) {
        this.wilaya = wilaya.trim().toLowerCase();
        this.commun = commun.trim().toLowerCase();
    }
    
    public String getWilaya() {
        return wilaya;
    }
    
    public String getCommun() {
        return commun;
    }
    
    public String toString() {
        return wilaya + ", " + commun;
    }
}
