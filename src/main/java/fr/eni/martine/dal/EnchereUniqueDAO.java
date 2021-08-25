package fr.eni.martine.dal;

import java.util.List;

import fr.eni.martine.bo.Enchere;

public interface EnchereUniqueDAO {

	
	public List <Enchere> selectUniqueEnchere(int noArticle) throws DalException; 
	
	
}
