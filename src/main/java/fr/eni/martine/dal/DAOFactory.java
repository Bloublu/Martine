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
}
