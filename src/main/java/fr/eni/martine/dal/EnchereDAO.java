package fr.eni.martine.dal;

import java.util.List;

import fr.eni.martine.bo.Enchere;

public interface EnchereDAO {

	
	public List<Enchere> selectAll() throws DalException;
	
	
}
