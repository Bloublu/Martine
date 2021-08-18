package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.martine.bll.ConnectionManager;
import fr.eni.martine.bo.User;

public class ConnectUDAOJdbcImpl implements ConnectUDAO{


	  
	 final static String SELECT_USER = "SELECT * from UTILISATEURS WHERE ( pseudo = ? OR  email = ?) AND  mot_de_passe =  ?;";
	    

	 @Override
	 	public User ConnectionUser(String identifiant, String Mdp) throws DalException{
	 		
	 		User CUser = null;
	 		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	             PreparedStatement pStmt = cnx.prepareStatement(SELECT_USER);
	             pStmt.setString(1, identifiant);
	             pStmt.setString(2, identifiant);
	             pStmt.setString(3, Mdp);
	             ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	CUser = new User(
	            			rs.getInt("no_utilisateur"),
	            			rs.getString("pseudo"),
	            			rs.getString("nom"),
	            			rs.getString("prenom"),
	            			rs.getString("email"),
	            			rs.getString("telephone"),
	            			rs.getString("rue"),
	            			rs.getInt("code_postal"),
	            			rs.getString("ville"),
	            			rs.getString("mot_de_passe"),
	            			rs.getInt("credit"),
	            			rs.getBoolean("administrateur")
	            			);
	            }
	             }
	          catch (SQLException e) {
	             e.printStackTrace();
	             throw new DalException(e.getMessage());
	
	 	}
	 		return CUser;

	}
	 

}


	
	
	

