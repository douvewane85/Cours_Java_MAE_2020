/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import modele.Client;
import modele.Compte;

/**
 *
 * @author Madoo Ndiaye
 */
public interface ICompte {
        public boolean creerCompte(Compte c);
        public ArrayList<Compte> listerCompte();
        public ArrayList<Compte> listerCompte(String numeroClient);
        public Client rechercherClient(String numeroClient);
        public Compte rehercherCompte(String numeroCompte);
       
}
