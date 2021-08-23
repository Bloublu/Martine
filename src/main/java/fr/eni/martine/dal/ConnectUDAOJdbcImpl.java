package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.eni.martine.bo.User;


public class ConnectUDAOJdbcImpl implements ConnectUDAO{
	
	


	final static String INSERT_INTO_INSCRIPTION = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,administrateur,credit)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,0,?);";

	final static String SELECT_USER = "SELECT * from UTILISATEURS WHERE ( pseudo = ? OR  email = ?) AND  mot_de_passe =  ?;";
	
	private final static String SELECT_USER_UTILISATEURS = "SELECT pseudo,nom,prenom,email,telephone,rue,code_postal,ville FROM UTILISATEURS;";


	@Override
 	public User ConnectionUser(String identifiant, String Mdp) throws DalException{
 		
 		User CUser = null;
 		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
             PreparedStatement pStmt = cnx.prepareStatement(SELECT_USER);
             pStmt.setString(1, identifiant);
             pStmt.setString(2, identifiant);
             pStmt.setString(3, Mdp);
             ResultSet rs = pStmt.executeQuery();
            
            while (rs.next()) {
            	CUser = new User(
            			rs.getInt("no_utilisateur"),
            			rs.getString("pseudo"),
            			rs.getString("nom"),
            			rs.getString("prenom"),
            			rs.getString("email"),
            			rs.getString("telephone"),
            			rs.getString("rue"),
            			rs.getString("code_postal"),
            			rs.getString("ville"),
            			rs.getString("mot_de_passe"),
            			rs.getInt("credit"),
            			rs.getBoolean("administrateur")
            			);
            }
             }
          catch (SQLException e) {
             e.printStackTrace();

             throw new DalException(e.getMessage());

 	}
 		return CUser;


}
		
		public void CreateUser(User user) throws DalException {

			try (Connection cnx = ConnectionProvider.getPoolConnexion()) {

				PreparedStatement pSt = cnx.prepareStatement(INSERT_INTO_INSCRIPTION);

				pSt.setString(1, user.getPseudo());
				pSt.setString(2, user.getNom());
				pSt.setString(3, user.getPrenom());
				pSt.setString(4, user.getEmail());
				pSt.setString(5, user.getTelephone());
				pSt.setString(6, user.getRue());
				pSt.setString(7, user.getCodepostal());
				pSt.setString(8, user.getVille());
				pSt.setString(9, user.getMotDePasse());
				pSt.setInt(10, user.getCredit());
				pSt.setInt(10, 100);

				pSt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
				if (e.getMessage().contains("utilisateurs_pseudo_uq")) {
					throw new DalException("Le pseudo doit être unique !");
				}
				if (e.getMessage().contains("utilisateurs_email_uq")) {
					throw new DalException("L'email doit être unique !");
				}
				throw new DalException("erreur dans la méthode Create User. Note technique : " + e.getMessage());

			}
		}
	 	
		public User SelectUtilisateur (String pseudo, String nom, String prenom, String email, String telephone, String rue , String code_postal, String ville ) throws DalException{
	 		
	 		User OtherUser = null;
	 		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	             PreparedStatement pStmt = cnx.prepareStatement(SELECT_USER_UTILISATEURS);
	             pStmt.setString(1, pseudo);
	             pStmt.setString(2, nom);
	             pStmt.setString(3, prenom);
	             pStmt.setString(4, email);
	             pStmt.setString(5, telephone);
	             pStmt.setString(6, rue);
	             pStmt.setString(7, code_postal);
	             pStmt.setString(8, ville);
	             ResultSet rs = pStmt.executeQuery();
	            
	            while (rs.next()) {
	            	OtherUser = new User(
	            			rs.getString("pseudo"),
	            			rs.getString("nom"),
	            			rs.getString("prenom"),
	            			rs.getString("email"),
	            			rs.getString("telephone"),
	            			rs.getString("rue"),
	            			rs.getString("code_postal"),
	            			rs.getString("ville")
	            			
	            			);
	            }
	             }
	          catch (SQLException e) {
	             e.printStackTrace();

	             throw new DalException(e.getMessage());

	 	}
	 		return OtherUser;

	}

	

	 }
	

