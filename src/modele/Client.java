package modele;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String numero;

    public void setId(int id) {
        this.id = id;
    }


    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return nom+" "+prenom;
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
