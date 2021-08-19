package fr.eni.martine.bll;

import fr.eni.martine.bo.User;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;
import fr.eni.martine.servlet.ServletConnection;


public class ConnectionManager {
	


	public  User ConnectUserBll(String identifiant, String Mdp)throws BllException {
		
		User CUserBll = null;
		
		try {
			
			CUserBll = DAOFactory.getArticleDAO().ConnectionUser(identifiant, Mdp);
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Problème de validation du profil. Note technique : " + e.getMessage());
		}
		return CUserBll;
	}
		
}	
	

