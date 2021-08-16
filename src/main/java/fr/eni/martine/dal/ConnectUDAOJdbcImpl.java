package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.martine.bo.User;

public class ConnectUDAOJdbcImpl implements ConnectUDAO{

	
	
	private static final String SQL_SELECT_USER = "SELECT pseudo, email, mot_de_passe FROM UTILISATEURS; ";
	
	
	
	@Override
	public boolean ConnectU() throws DalException {
		// List<User> affuser = new ArrayList<>();
		boolean toto = true;
		 User user;
		try {
		
			Connection cnx = ConnectionProvider.getPoolConnexion();
			PreparedStatement pSt = cnx.prepareStatement(SQL_SELECT_USER);
			ResultSet resultSet = pSt.executeQuery();
	        while (resultSet.next()) {
	            user = new User(
	                    resultSet.getString("pseudo"),
	                    resultSet.getString("email"),
	                    resultSet.getString("MDP")
	                    );
	            //user.add(user);
	        }			
	        if ((user.getPseudo().equals(resultSet.getString("pseudo")) || user.getPseudo().equals(resultSet.getString("email"))) 
	        		|| (user.getEmail().equals(resultSet.getString("email")) || user.getEmail().equals(resultSet.getString("pseudo")))){
	        	
	        	if(user.getMotDePasse().equals(resultSet.getString("MDP"))){
	        		toto = true;
	        		return toto;
	        	}
	        }else 
	        	toto = false;
	        	return toto;
	        
	        
	       
	        
			cnx.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DalException("Une erreur est apparue lors de la communication vers la BDD");
			
		}
		//return affuser;
	}
	
	
	
	
	
	
	
	
}
