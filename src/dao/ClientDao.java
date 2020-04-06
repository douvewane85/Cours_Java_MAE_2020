/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Client;


/**
 *
 * @author hp
 */
public class ClientDao implements IDao<Client> {

    private final String SQL_BY_NUM="Select * From client where numero =? ";
     private final String SQL_BY_ID="Select * From client where id =? ";
    private final String SQL_INSERT="INSERT INTO `client` (`id`, `numero`, `nom`, `prenom`) VALUES (NULL, ?, ?, ?)";
    
    private MysqlDB mysql;

    public ClientDao() {
        mysql=new MysqlDB();
    }
    
    
    @Override
    public int create(Client obj) {
        int result=0;
        try {
              mysql.initPS(SQL_INSERT);
              mysql.getPstm().setString(1, obj.getNumero());
              mysql.getPstm().setString(2, obj.getNom());
              mysql.getPstm().setString(3, obj.getPrenom());
             //5 Execution de la requete
              mysql.executeMaj();
              //REturn ID client ID
              ResultSet rs=mysql.getPstm().getGeneratedKeys();
              if(rs.first())  result=rs.getInt(1);
             
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    @Override
    public boolean update(Client obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Client> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client selectById(int id) {
        try {
            //PreparedStatement ps = cnx.prepareStatement(requete);
            mysql.initPS(SQL_BY_ID);
            //ps.setString(1, numero);
            mysql.getPstm().setInt(1, id);
            ResultSet rs = mysql.executeSelect();
            if(rs.first()){
                Client cl = new Client();
                cl.setId(rs.getInt("id"));
                cl.setNumero(rs.getString("numero"));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                
                return cl;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Client selectByNumero(String numero) {
        try {
            //PreparedStatement ps = cnx.prepareStatement(requete);
            mysql.initPS(SQL_BY_NUM);
            //ps.setString(1, numero);
            mysql.getPstm().setString(1, numero);
            ResultSet rs = mysql.executeSelect();
            if(rs.first()){
                Client cl = new Client();
                cl.setId(rs.getInt("id"));
                cl.setNumero(rs.getString("numero"));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                
                return cl;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
