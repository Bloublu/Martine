package fr.eni.martine.bll;

import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.servlet.BLLExeception.BllException;


public class ConnectionManager {

	
	public  Boolean ConnectUserBll(String identifiant, String Mdp)throws BllException {
		
		Boolean CUserBll = false;
		
		try {
			
			CUserBll = DAOFactory.getArticleUDAO().ConnectionUser(identifiant, Mdp);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			//throw new BllException("erreur dans la méthode ConnectUserBll");
		}
		return CUserBll;
	}
		
}	
	

