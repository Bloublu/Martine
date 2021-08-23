package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import fr.eni.martine.bo.Article;
import fr.eni.martine.bo.Enchere;
import fr.eni.martine.bo.User;


public class ConnectUDAOJdbcImpl implements ConnectUDAO{
	
	


	final static String INSERT_INTO_INSCRIPTION = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,administrateur,credit)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,0,?);";

	final static String SELECT_USER = "SELECT * from UTILISATEURS WHERE ( pseudo = ? OR  email = ?) AND  mot_de_passe =  ?;";

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
	 	
	

	

	 }
	

