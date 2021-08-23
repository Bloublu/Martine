package fr.eni.martine.bll;

import java.util.List;

import fr.eni.martine.bo.Enchere;
import fr.eni.martine.dal.ConnectUDAO;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;
import fr.eni.martine.dal.EnchereDAO;

public class ListEnchereManager {

	private EnchereDAO daoEnchere;
	
	
	
	
	
	public ListEnchereManager( ) {
		super();
		this.daoEnchere = DAOFactory.getEnchereDAO();
	}



	public static List<Enchere> getEnchere() throws BllException {
		
		List<Enchere> enchereList = null;
		try {
			
		
			enchereList = DAOFactory.getEnchereDAO().selectAll();
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme de validation du profil. Note technique : " + e.getMessage());
		
		}
		
		return enchereList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
