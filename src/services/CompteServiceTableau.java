package services;

import modele.Client;
import modele.Compte;

public class CompteServiceTableau {
    final int TAILLE = 10;
    int position =0;

    Compte[] bd = new Compte[TAILLE];

    public boolean creerCompte(Compte c) {
        bd[position] =c;
        position++;
        return false;
    }

    public Compte[] listerCompte() {
        return bd;
    }

    public Compte[] listerCompte(String numeroClient) {
        Compte[] compteClient = new Compte[TAILLE];
        int position = 0;
        for (Compte c : bd) {
            if (rechercherClient(numeroClient) != null) {
                compteClient[position] = c;
                position++;
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

    public Compte rechercherCompte(String numeroCompte){
        for (Compte c : bd) {
            if (c.getNumero().compareTo(numeroCompte) == 0) {
                return c;

            }
        }
        return null;
    }
}
