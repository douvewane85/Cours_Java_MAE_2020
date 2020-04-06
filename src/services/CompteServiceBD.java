/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ClientDao;
import dao.CompteDao;
import java.util.ArrayList;
import modele.Client;
import modele.Compte;

/**
 *
 * @author hp
 */
public class CompteServiceBD implements ICompte {
    private ClientDao daoClient;
    private CompteDao daoCompte;
    
    public CompteServiceBD(){
        daoClient = new ClientDao();
        daoCompte = new CompteDao();
    }

    @Override
    public boolean creerCompte(Compte c) {
        if(c.getClient().getId()==0){
           int id= daoClient.create(c.getClient());
           c.getClient().setId(id);  
        }
       return daoCompte.create(c)!=0;  
    }

    @Override
    public ArrayList<Compte> listerCompte() {
        return daoCompte.selectAll();
    }

    @Override
    public ArrayList<Compte> listerCompte(String numeroClient) {
        return daoCompte.selectCompteByClient(numeroClient);
    }

    @Override
    public Client rechercherClient(String numeroClient) {
        return daoClient.selectByNumero(numeroClient);
    }

    @Override
    public Compte rehercherCompte(String numeroCompte) {
        return daoCompte.selectByNumero(numeroCompte);
    }
    
}
