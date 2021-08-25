package fr.eni.martine.dal;


import fr.eni.martine.bo.User;


public interface ConnectUDAO {


	public User ConnectionUser(String identifiant, String Mdp) throws DalException;

	public void CreateUser (User user)throws DalException;	
	
	public User SelectUtilisateur (int id) throws DalException;


	
	
}
