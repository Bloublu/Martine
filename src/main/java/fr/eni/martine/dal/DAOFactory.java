package fr.eni.martine.dal;

public class DAOFactory {

	public static ConnectUDAO getConnectUDAO() {
		
		return new ConnectUDAOJdbcImpl();
	}
	
	
}
