package fr.eni.martine.dal;

public class DAOFactory {

	    public static ConnectUDAO getArticleDAO() { 
	        ConnectUDAO uDAO = new ConnectUDAOJdbcImpl();
	        return uDAO;

	    }


	    public static ArticleDAO getNewArticleDAO() { 
	        ArticleDAO uDAO = new ArticleDAOJdbcImpl();
	        return uDAO;
	    }
}
