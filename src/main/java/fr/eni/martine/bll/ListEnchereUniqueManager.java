package fr.eni.martine.bll;

import java.util.List;

import fr.eni.martine.bo.Enchere;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class ListEnchereUniqueManager {

	
	
public static List <Enchere> getEnchereUnique(int noArticle) throws BllException {
		
		List<Enchere> enchereUnique = null;
		try {
			enchereUnique = DAOFactory.getEnchereUniqueDAO().selectUniqueEnchere(noArticle);
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme de validation du profil. Note technique : " + e.getMessage());
		
		}
		
		return enchereUnique;
	}
	
	
	
	
	
	
	
	
}
