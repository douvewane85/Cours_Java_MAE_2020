package modele;

public class CompteCheque extends Compte {
    protected final int frais=200;


    public CompteCheque() {
        super();
        this.attribute_number("CCH");
        type="Cheque";
    }



    @Override
    public void depot(double montant) {
        this.solde += montant-frais;
    }

    @Override
    public void retrait(double montant) {
        if (this.solde >= montant+frais)
            this.solde -= montant+frais;

    }

    public void virement(CompteCheque compteDepot,double montant){
        this.retrait(montant);
        compteDepot.depot(montant);
    }


    public int getFrais() {
        return frais;
    }

    @Override
    public String toString() {
        return super.toString() +" frais = " + frais;
    }
}
