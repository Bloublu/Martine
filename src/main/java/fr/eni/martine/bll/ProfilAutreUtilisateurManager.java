package fr.eni.martine.bll;

import fr.eni.martine.bo.User;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class ProfilAutreUtilisateurManager {

public  User AffUtiliBll(int id)throws BllException {
		
		User affUserBll = null;
		
		try {
			
			affUserBll = DAOFactory.getNewAffUtiliDAO().SelectUtilisateur(id);
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme d'affichage du profil de l'utilisateur. Note technique : " + e.getMessage());
		}
		return affUserBll;
	}

	
	
	
	
	
	
	
}
