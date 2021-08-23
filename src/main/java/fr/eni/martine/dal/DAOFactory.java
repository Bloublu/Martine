package fr.eni.martine.dal;

import java.time.LocalDateTime;

public class DAOFactory {

	    public static ConnectUDAO getArticleDAO() { 
	        ConnectUDAO uDAO = new ConnectUDAOJdbcImpl();
	        return uDAO;

	    }

	    public static EnchereDAO getEnchereDAO() {
	    	EnchereDAO eDAO = new EnchereDAOJdbcImpl();
	    	return eDAO;
	    }

		public static ArticleDAO getNewArticleDAO() {
			ArticleDAO articleDAO = new ArticleDAOJdbcImpl();
			return articleDAO;
			
		}

}
