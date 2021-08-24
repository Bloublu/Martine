package fr.eni.martine.bll;


import java.time.LocalDate;
import java.time.LocalDateTime;
import fr.eni.martine.bo.Article;
import fr.eni.martine.dal.ArticleDAO;
import fr.eni.martine.dal.ConnectUDAO;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;

public class ArticleManager {

	

	LocalDateTime todaysDate = LocalDateTime.now();
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		
		this.articleDAO = DAOFactory.getNewArticleDAO(); 
	
	}



		public void createArticle(String nom_article, String description, LocalDateTime date_debut_enchere, LocalDateTime date_fin_enchere, 
			int prix_initial, int prix_vente, int no_categorie, int no_utilisateur, String image) throws DalException, BllException {
		
			
			
			Article articleAInserer = new Article(nom_article, description, date_debut_enchere, date_fin_enchere, 
					prix_initial, prix_vente, no_categorie, "CR", no_utilisateur, image);
			
			
			this.articleDAO.CreateArticle(articleAInserer);
			
		
			//Contraintes pour validation des champs :

			if(nom_article == null || nom_article.equalsIgnoreCase("")) {
	            throw new BllException("Erreur dans le nom de l'article");
			}
			if(description == null || description.equalsIgnoreCase("")) {
				throw new BllException("Erreur dans la description de l'article");
			}
			// Contrainte pour que la date début enchère soit égal à la date du jour :
			if(date_debut_enchere != todaysDate) {
				throw new BllException("La date de début de l'enchère doit être à la date du jour");
			}
			// Contrainte pour que la date de fin ne soit pas antérieure à la date de début
			if(date_fin_enchere != date_debut_enchere) {
				throw new BllException("Erreur dans la date de fin de l'enchère");
			}
			
			try {
				articleDAO.CreateArticle(articleAInserer);
			} catch (DalException e) {
				 e.printStackTrace();
			}
			
			
	}
		
}

	
	