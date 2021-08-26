package fr.eni.martine.dal;

import java.util.List;

import fr.eni.martine.bo.Enchere;

public interface EnchereUniqueDAO {

	
	public Enchere selectUniqueEnchere(int noArticle) throws DalException; 
	
	public void Encherir(int encherir, int idArticle) throws DalException;
}
