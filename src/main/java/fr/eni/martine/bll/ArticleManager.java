package fr.eni.martine.bll;


import java.time.LocalDateTime;
import fr.eni.martine.bo.Article;
import fr.eni.martine.dal.ArticleDAO;
import fr.eni.martine.dal.ConnectUDAO;
import fr.eni.martine.dal.DAOFactory;
import fr.eni.martine.dal.DalException;




public class ArticleManager {

	private ArticleDAO articleDAO;
	

	
		public ArticleManager() {
		
		this.articleDAO = DAOFactory.getNewArticleDAO();
	}



		public void createArticle(String nom_article, String description, LocalDateTime date_debut_enchere, LocalDateTime date_fin_enchere, 
			int prix_initial, int prix_vente, int no_categorie, int no_utilisateur, String image) throws DalException {
		
			
			
			Article articleAInserer = new Article(nom_article, description, date_debut_enchere, date_fin_enchere, 
					prix_initial, prix_vente, no_categorie, "CR", no_utilisateur, image);
			
			
			this.articleDAO.CreateArticle(articleAInserer);
			
		
			// RAJOUTER LES IF POUR VALIDER LES CHAMPS

			}
	}
	
	