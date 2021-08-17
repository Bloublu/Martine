package fr.eni.martine.dal;

public class DAOFactory {

	public static ConnectUDAO getArticleUDAO() {
		
		return new ConnectUDAOJdbcImpl();
	}
	
	
}
