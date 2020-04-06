package modele;

import java.util.Date;

public abstract class Compte {
    private static int cpt =0;

    //Propriétés
    private int id;
    protected String numero;
    protected double solde;
    protected Date createAt;
    protected String type;

    public String getType() {
        return type;
    }



    //Propriétés de navigation
    protected Client client;

    //Methodes

    //Constructeurs
    public Compte(){
        id = ++cpt;
        createAt = new Date();
        this.solde=2000;

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public int getId() {
        return id;
    }
    
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    public abstract void depot(double montant);

    public abstract void retrait(double montant);




    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", createAt=" + createAt +
                ", client=" + client +
                '}';
    }


    

    

    protected void attribute_number(String debut){
        //Resultat =    CCH00001

        String id = Integer.toString(this.getId());
        numero = debut + "0"+ id;
    }
}
