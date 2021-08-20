package fr.eni.martine.bll;

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
	
	
	
	
	
public void CreateUser(String pseudo, String motdepasse, String prenom,String rue,String telephone,String nom,
String codepostal,String ville, String email) throws BllException {
 
	User user= new User (pseudo,nom,prenom,email,telephone,rue,codepostal,ville,motdepasse);

	try {
		this.connectUDAO.CreateUser(user);
		
	} catch (DalException e) {
		
		e.printStackTrace();
	}
	
	}

	
	public boolean Validation1(String str) throws BllException {
		char[] charTab = str.toCharArray();
      
		boolean isAlpha = true;
      
		for (char c : charTab) {
     	
       if (!Character.isAlphabetic(c))
		isAlpha = false;   
      }
		
      return isAlpha;
        }


	
}








