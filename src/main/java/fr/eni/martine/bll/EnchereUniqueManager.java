package fr.eni.martine.bll;

import java.util.List;

import fr.eni.martine.bo.Enchere;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class EnchereUniqueManager {

	
	
public static Enchere getEnchereUnique(int noArticle) throws BllException {
		
	Enchere enchereUnique = null;
		try {
			enchereUnique = DAOFactory.getEnchereUniqueDAO().selectUniqueEnchere(noArticle);
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme de validation du profil. Note technique : " + e.getMessage());
		
		}
		
		return enchereUnique;
	}
	
public void getEncherir(int encherir, int idArticle) throws BllException{
	try {
		DAOFactory.getEnchereUniqueDAO().Encherir(encherir, idArticle);
		
	}catch(DalException e) {
		
		e.printStackTrace();
		throw new BllException("Probleme de validation du profil. Note technique : " + e.getMessage());
	
	}
}
	
	
	
	
	
	
}
