package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.martine.bo.User;

public class ConnectUDAOJdbcImpl implements ConnectUDAO{

	
	
	
	  
	 final static String SELECT_USER = "SELECT * from UTILISATEURS WHERE pseudo LIKE ? OR email LIKE ? AND mot_de_passe = ?;";
	    

	 @Override
	 	public Boolean ConnectionUser(String identifiant, String Mdp) throws DalException{
	 		Boolean CUser = false;
	 		
	 		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	             PreparedStatement pStmt = cnx.prepareStatement(SELECT_USER);
	             pStmt.setString(1, identifiant);
	             pStmt.setString(2, identifiant);
	             pStmt.setString(3, Mdp);
	             ResultSet rs = pStmt.executeQuery();
	            CUser = rs.next();
	             }
	          catch (Exception e) {
	             e.printStackTrace();
	             throw new DalException("erreur dans la méthode ConnectionUser");
	         
	 		
	 		
	 	}return CUser;
		
	}
	 
}
//    // if ((user.getPseudo().equals(resultSet.getString("pseudo")) || user.getPseudo().equals(resultSet.getString("email"))) 
//	|| (user.getEmail().equals(resultSet.getString("email")) || user.getEmail().equals(resultSet.getString("pseudo")))){
//
//if(user.getMotDePasse().equals(resultSet.getString("MDP"))){
//	toto = true;
//	return toto;
//}
//}else 
//toto = false;
//return toto;
	
	
	
	
	
	
	

