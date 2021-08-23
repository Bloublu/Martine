package fr.eni.martine.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.martine.bo.User;
import fr.eni.martine.dal.ConnectUDAO;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class InscriptionManager {

	private ConnectUDAO connectUDAO;

	public InscriptionManager() {
		super();
		this.connectUDAO = DAOFactory.getArticleDAO();
	}

	public void CreateUser(String pseudo, String motdepasse, String prenom, String rue, String telephone, String nom,
			String codepostal, String ville, String email, String motpasseconfirmation) throws BllException {

		User user = new User(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motdepasse);

		try {
			if (!VerifPseudo(pseudo)) {
				throw new BllException("Le pseudo doit contenir uniquement des caracteres alphanumériques");
			}
			if (!validerMotDePasse(motdepasse, motpasseconfirmation)) {
				throw new BllException("le mot de passe n'est pas identique au mot de passe renseigné");
			}
			this.connectUDAO.CreateUser(user);

		} catch (DalException e) {

			e.printStackTrace();
			throw new BllException(e.getMessage());
		}
	}


	public boolean VerifPseudo(String verifpseudo) {

		boolean verif = false;

		if (verifpseudo.matches("^[a-zA-Z0-9]+$")) {
			verif = true;
		}

		return verif;
	}
	
	public boolean validerMotDePasse(String motdepasse, 
		String motpasseconfirmation) {	
		
        boolean validmdp = false;
        
            if (motdepasse != null && motdepasse.equals(motpasseconfirmation)) {
            	validmdp = true; 
            }
        return validmdp;
	
	}
}
