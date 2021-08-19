package fr.eni.martine.bll;

import java.util.List;

import fr.eni.martine.bo.Enchere;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class ListEnchereManager {

	
	
	
	
	public List<Enchere> getEnchere() throws BllException {
		
		List<Enchere> enchereList = null;
		try {
			
		
			enchereList = DAOFactory.getArticleDAO().selectAll();
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme de validation du profil. Note technique : " + e.getMessage());
		
		}
		
		return enchereList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
