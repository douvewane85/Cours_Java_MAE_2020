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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MysqlDB {
  private String user="root";  
  private String pwd=""; 
  private String server="localhost"; 
  private String bd="coursjava";
  private Connection cnx;
  private PreparedStatement pstm;
  
  
    public Connection getCnx() {
        return cnx;
    }

 
   public void initPS(String sql)
	{
		getConnexion();
		try{
			  if(sql.toLowerCase().startsWith("insert"))
			     {
			    	pstm=cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			     }
			else{
				   pstm=cnx.prepareStatement(sql);
		        }
		    }catch(Exception e)
		{
			e.printStackTrace();
		}

	}
  
  
  public void getConnexion(){
      try {
          //Chargement du Driver
          Class.forName("com.mysql.jdbc.Driver"); 
          //Etablir la Connexion
           cnx= DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+bd, user,pwd); 
              System.out.println("Connection Reussie");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(MysqlDB.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(MysqlDB.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public int executeMaj()
	{
            int ok=0;
		try {
			ok = pstm.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return ok;
	}
	public ResultSet executeSelect()
	{
             ResultSet  rs=null;
		try {
 
			rs=pstm.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return rs;
	}
	public PreparedStatement getPstm()
	{
		return  this.pstm;

	}
 public void CloseConnexion(){
      try {
          cnx.close();
      } catch (SQLException ex) {
          Logger.getLogger(MysqlDB.class.getName()).log(Level.SEVERE, null, ex);
      }
  } 
  
}
