package services;
import modele.Client;
import modele.Compte;

import java.util.ArrayList; // import the ArrayList class
import java.util.Date;
import modele.CompteCheque;
import modele.CompteEpargne;


public class CompteServiceListe implements ICompte{

    ArrayList<Compte> bd = new ArrayList<Compte>();

    public CompteServiceListe() {
        Compte cp= new CompteCheque();
        cp.setNumero("XXXX");
        cp.setSolde(1000000);
        cp.setCreateAt(new Date());
        Client cl=new Client();
        cl.setNumero("XXX");
        cl.setNom("JUNIOR");
        cl.setPrenom("THIAM");
        
        cp.setClient(cl);
        bd.add(cp);
        
        Compte cp1= new CompteEpargne();
        cp1.setNumero("XXY");
        cp1.setSolde(2000000);
        cp1.setClient(cl);
        bd.add(cp1);
        
    }
    

    @Override
    public boolean creerCompte(Compte c){
        bd.add(c);
        return true;
    }

    public ArrayList<Compte> listerCompte() {
        return bd;
    }

    public ArrayList<Compte> listerCompte(String numeroClient) {
        ArrayList<Compte> compteClient = new ArrayList<Compte>();
        for (Compte c : bd) {
            if (rechercherClient(numeroClient) != null) {
                compteClient.add(c);
            }
        }
        return compteClient;

    }

    public Client rechercherClient(String numeroClient) {
        for (Compte c : bd) {
            if (c.getClient().getNumero().compareTo(numeroClient) == 0) {
                return c.getClient();
            }

        }
        return null;
    }

    public Compte rehercherCompte(String numeroCompte){
        for (Compte c : bd) {
            if (c.getNumero().compareTo(numeroCompte) == 0) {
                return c;

            }
        }
        return null;
    }


}
