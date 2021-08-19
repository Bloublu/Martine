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

	final static String INSERT_INTO_INSCRIPTION ="INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,codepostal,ville,motdepasse)"
			+ "VALUES(?,?,?,?,?,?,?,?,?);";

	 final static String SELECT_USER = "SELECT * from UTILISATEURS WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?;";
	    

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
	 
	 	public void CreateUser (User user)throws DalException {

	 	try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	 		
	 	PreparedStatement pSt = cnx.prepareStatement(INSERT_INTO_INSCRIPTION);
	 	
	 	pSt.setString(1, user.getPseudo());
        pSt.setString(2, user.getNom());
        pSt.setString(3,user.getPrenom());
        pSt.setString(4,user.getEmail());
        pSt.setString(5,user.getTelephone());
        pSt.setString(6,user.getRue());
        pSt.setString(7,user.getCodepostal());
        pSt.setString(8,user.getVille());
        pSt.setString(9,user.getMotDePasse());
        
         pSt.executeUpdate();
       
	 	} catch (SQLException e) {
	 		
        e.printStackTrace();
        
        throw new DalException("erreur dans la méthode Create User");

	 	}
	}
}

	
	
	
	
	
	
	
	

