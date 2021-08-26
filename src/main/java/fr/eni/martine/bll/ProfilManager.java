package fr.eni.martine.bll;

import fr.eni.martine.bo.User;
import fr.eni.martine.dal.ConnectUDAO;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class ProfilManager {
	
	private ConnectUDAO connectUDAO;

	public ProfilManager() {
		super();
		this.connectUDAO = DAOFactory.getArticleDAO();
	}
	
	public void Mdp (String motpasseconfirmation,String nouveaumotdepasse) throws BllException{

	if (!validerMotDePasse(motpasseconfirmation, nouveaumotdepasse)) {
		throw new BllException("le mot de passe n'est pas identique au mot de passe renseigné");
	}
	
	}
	
	public User UpdateUser (String pseudo, String nom,String prenom, String email, String telephone, String rue, String codepostal, String ville, String motdepasse, int id )
			throws BllException {
		
		User user = new User(id, pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motdepasse);
		
		try {
			
			connectUDAO.UpdateUtilisateur(user);
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme d'affichage du profil de l'update. Note technique : " + e.getMessage());
		}
		return user;
	}

	public void DeleteUser ( int id )
			throws BllException {
		
		try {
			
			connectUDAO.DeleteUtilisateur(id);
			
		}catch(DalException e) {
			
			e.printStackTrace();
			throw new BllException("Probleme dans le DeleteUser (Manager). Note technique : " + e.getMessage());
		}
		
	}
	
	
	public boolean validerMotDePasse(String motpasseconfirmation, 
			String nouveaumotdepasse) {	
			
	        boolean validmdp = false;
	        
	            if (motpasseconfirmation != null && motpasseconfirmation.equals(nouveaumotdepasse)) {
	            	validmdp = true; 
	            }
	        return validmdp;
		
		}
	
	
	
}
