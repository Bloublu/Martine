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
		

		public static EnchereUniqueDAO getEnchereUniqueDAO() {
			EnchereUniqueDAO UniqueEnchereDAO = new EnchereUniqueDAOJdbcImpl();
			return UniqueEnchereDAO;
			
		}

		public static ConnectUDAO getNewAffUtiliDAO() {
			ConnectUDAO affutiliDAO = new ConnectUDAOJdbcImpl();
			return affutiliDAO;
			
		}
		
		public static ConnectUDAO getUpdate() {
			ConnectUDAO updateDAO = new ConnectUDAOJdbcImpl();
			return updateDAO;
			
		}
		
		public static ConnectUDAO getDelete() {
			ConnectUDAO deleteDAO = new ConnectUDAOJdbcImpl();
			return deleteDAO;
			
		}


}
