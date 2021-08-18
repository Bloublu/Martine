package fr.eni.martine.dal;

import java.sql.SQLException;

import fr.eni.martine.bo.User;

public interface ConnectUDAO {

	

	public User ConnectionUser(String identifiant, String Mdp) throws DalException;
	
	
	
	
	
	
}
