package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectUDAOJdbcImpl implements ConnectUDAO{

	
	
	private static final String SQL_SELECT_USER = "SELECT pseudo, email, mot_de_passe FROM UTILISATEUR; ";
	
	
	
	@Override
	public List<USER> ConnectU() throws DalException {
		 List<USER> affuser = new ArrayList<>();
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
	            affuser.add(user);
	        }			
	        if (user.getSpeudo.equlas(resultSet.getString("pseudo"))
	        
	        
	       // (aObject.equals(bObject) && bObject.equals(aObject));
	        
			cnx.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new BusinessException("Une erreur est apparue lors de la communication vers la BDD");
			
		}
		return affavis;
	}
	
	
	
	
	
	
	
	
}
