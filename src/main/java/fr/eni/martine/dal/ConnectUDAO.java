package fr.eni.martine.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.martine.bo.Enchere;
import fr.eni.martine.bo.User;


public interface ConnectUDAO {


	public User ConnectionUser(String identifiant, String Mdp) throws DalException;

	public void CreateUser (User user)throws DalException;	

	public List<Enchere> selectAll() throws DalException;
	
	
}
