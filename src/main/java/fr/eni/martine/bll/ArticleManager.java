package fr.eni.martine.bll;

import java.time.LocalDateTime;
import fr.eni.martine.bo.Article;
import fr.eni.martine.dal.ArticleDAO;
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
			
			//Contraintes pour validation des champs :
			try {
				
				if (!verifNomArticle(nom_article)) {
					throw new BllException("Erreur dans le nom de l'article");
				}
				
				if(!verifDescription(description)) {
					throw new BllException("Erreur dans la description de l'article");
				}
				
				
				articleDAO.CreateArticle(articleAInserer);
			} catch (DalException e) {
				 e.printStackTrace();
			}
			
	}
		// Méthode (reliée aux contraintes du dessus) verif nom Article :
		
			public boolean verifNomArticle(String nom_article) {
				
				boolean verif = false;
				
				if (nom_article != null && !nom_article.isEmpty()) {
					verif = true;
				}
				return verif;
	}
		// Méthode reliée aux contraintes du dessus) verif description :
			
			public boolean verifDescription(String description) {
				
				boolean verif = false;
				
				if (description != null && !description.isEmpty()) {
					verif = true;
				}
				return verif;
	}


			
			
			
		// Méthode ValiderArticle (pour afficher détails vente) :	
		public Article getNoArticle(int NoArticle) throws DalException, BllException {
			Article article = null;
			try {
				article = DAOFactory.getNewArticleDAO().ValiderArticle(NoArticle);
			} catch (DalException e) {
				throw new BllException("Erreur dans la méthode ValideArticle");	
			}
			return article;
		}
}
			

	
	