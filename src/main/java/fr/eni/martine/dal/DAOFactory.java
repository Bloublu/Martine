package fr.eni.martine.dal;


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
		
		public static ConnectUDAO getNewAffUtiliDAO() {
			ConnectUDAO affutiliDAO = new ConnectUDAOJdbcImpl();
			return affutiliDAO;
			
		}
		
		
		

}
