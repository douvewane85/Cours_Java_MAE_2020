/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Client;
import modele.Compte;
import modele.CompteCheque;
import modele.CompteEpargne;

/**
 *
 * @author hp
 */
public class CompteDao implements IDao<Compte> {
  private final String SQL_ALL="Select * From compte ";
  private final String SQL_INSERT="INSERT INTO `compte` (`numero`, `solde`, `createAt`, `type`, `frais`, `taux`, `dateDeblocage`, `idClient`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
    
    private MysqlDB mysql;
    private ClientDao daoClient;
    public CompteDao() {
        mysql=new MysqlDB();
        daoClient=new ClientDao();
    }
    @Override
    public int create(Compte obj) {
        
       int result=0;
        try {
              mysql.initPS(SQL_INSERT);
              mysql.getPstm().setString(1, obj.getNumero());
              mysql.getPstm().setDouble(2, obj.getSolde());
              mysql.getPstm().setDate(3, null);
              mysql.getPstm().setString(4,obj.getType());
              mysql.getPstm().setInt(8,obj.getClient().getId());
              mysql.getPstm().setInt(6,0);
              mysql.getPstm().setDate(7,null);
              mysql.getPstm().setInt(5,0);
              
              if(obj.getType().compareTo("Epargne")==0){ 
                 mysql.getPstm().setInt(6,((CompteEpargne)obj).getTaux()); 
                 mysql.getPstm().setDate(7, null); 
              }else{
                  mysql.getPstm().setInt(5,((CompteCheque)obj).getFrais()); 
              }
        
             //5 Execution de la requete
              result=mysql.executeMaj();
             
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
        
    }

    @Override
    public boolean update(Compte obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Compte> selectAll() {
            ArrayList<Compte> comptes=null;
                try {
                    comptes=new ArrayList<Compte>(); 
            //PreparedStatement ps = cnx.prepareStatement(requete);
            mysql.initPS(SQL_ALL);
            ResultSet rs = mysql.executeSelect();
            while(rs.next()){
                Compte compte=null ;
                if(rs.getString("type").compareTo("Epargne")==0){
                   compte = new CompteEpargne(); 
                   ((CompteEpargne)compte).setTaux(rs.getInt("taux"));
                }else{
                    compte = new CompteCheque(); 
                }
                
                compte.setId(rs.getInt("id"));
                compte.setNumero(rs.getString("numero"));
                compte.setSolde(rs.getDouble("solde"));
                int id=rs.getInt("idClient");
                compte.setClient(daoClient.selectById(id));
                comptes.add(compte);
                
               
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comptes;

        
    }

    @Override
    public Compte selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compte selectByNumero(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Compte> selectCompteByClient(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
