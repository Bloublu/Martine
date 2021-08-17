package fr.eni.martine.bll;

import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.servlet.BLLExeception.BllException;
import fr.eni.martine.servlet.ServletConnection;


public class ConnectionManager {
	


	public  Boolean ConnectUserBll(String identifiant, String Mdp)throws BllException {
		
		Boolean CUserBll = false;
		
		try {
			
			CUserBll = DAOFactory.getArticleDAO().ConnectionUser(identifiant, Mdp);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			//throw new BllException("erreur dans la méthode ConnectUserBll");
		}
		return CUserBll;
	}
		
}	
	

