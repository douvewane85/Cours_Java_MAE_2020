package modele;

import java.util.Date;

public class CompteEpargne extends Compte {
    private int taux;
    private Date dateDeblocage;


    public CompteEpargne() {
        super();
        this.attribute_number("CE");
        type="Epargne";
    }

    public CompteEpargne(int taux, Date dateDeblocage) {
        this.taux = taux;
        this.dateDeblocage = dateDeblocage;
    }


    @Override
    public void depot(double montant) {
        this.solde+= montant;

    }

    @Override
    public void retrait(double montant) {
        if (new Date().after(this.dateDeblocage)  ){
            System.out.println("La date de deblocage est Bien passé ");
            this.solde-= montant;
        }else {
            System.out.println("Impossible de retirer ! date de deblocage n'est pas encore arrivé");
        }

    }

    public void virement(CompteEpargne compteDepot,double montant) {
        this.retrait(montant);
        compteDepot.depot(montant);

    }

    public int getTaux() {
        return taux;
    }

    public void setTaux(int taux) {
        this.taux = taux;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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


    public Date getDateDeblocage() {
        return dateDeblocage;
    }

    public void setDateDeblocage(Date dateDeblocage) {
        this.dateDeblocage = dateDeblocage;
    }

    @Override
    public String toString() {
        return super.toString()+
                " taux= " + taux +
                ", dateDeblocage= " + dateDeblocage;
    }
}
