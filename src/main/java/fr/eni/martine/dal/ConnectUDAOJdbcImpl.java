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
	
	

	final static String INSERT_INTO_INSCRIPTION ="INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,administrateur,credit)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,100,?);";
  
	 final static String SELECT_USER = "SELECT * from UTILISATEURS WHERE ( pseudo = ? OR  email = ?) AND  mot_de_passe =  ?;";

	    final static String SELECT_ENCHERE = "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE etat_vente = 'EC';";

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
	 
	 	public void CreateUser (User user)throws DalException {

	 	try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	 		
	 	PreparedStatement pSt = cnx.prepareStatement(INSERT_INTO_INSCRIPTION);
	 	
	 	pSt.setString(1,user.getPseudo());
        pSt.setString(2,user.getNom());
        pSt.setString(3,user.getPrenom());
        pSt.setString(4,user.getEmail());
        pSt.setString(5,user.getTelephone());
        pSt.setString(6,user.getRue());
        pSt.setString(7,user.getCodepostal());
        pSt.setString(8,user.getVille());
        pSt.setString(9,user.getMotDePasse());
        pSt.setInt(10,user.getCredit());
        
         pSt.executeUpdate();
       
	 	} catch (SQLException e) {
	 		
        e.printStackTrace();
        
        throw new DalException("erreur dans la méthode Create User");

	 	}
	}

	 @Override
	     public List<Enchere> selectAll() throws DalException {
	         
	         List<Enchere> enchereList = new ArrayList<>();
	         Enchere enchere = null;
	         Article article = null;
	         User utilisateur = null;
	         
	         try 	(Connection cnx = ConnectionProvider.getPoolConnexion()) {
	     	 		PreparedStatement pSt = cnx.prepareStatement(SELECT_ENCHERE);
	     	 		ResultSet rs = pSt.executeQuery();
	             while (rs.next()) {
	                    
						enchere = new Enchere(
								rs.getDate("date_enchere").toLocalDate(),
								rs.getTime("date_enchere").toLocalTime(),
                				rs.getInt("montant_enchere")
	                            );
	                    
	                     article = new Article(
	                    		 rs.getString("nom_article"),
	                    		 rs.getString("description"),	        
	                    		 rs.getDate("date_debut_enchere").toLocalDate(),
								 rs.getTime("date_debut_enchere").toLocalTime(),
							    	rs.getDate("date_fin_enchere").toLocalDate(),
								 rs.getTime("date_fin_enchere").toLocalTime(),	                    		 
	                    		 rs.getInt("prix_initial"),
	                    		 rs.getInt("prix_vente"),
	                    		 rs.getInt("no_categorie"),
	                    		 rs.getString("etat_vente"),
	                    		 rs.getString("image")	                    
	                     );
	                     enchere.setArticle(article);
	                     utilisateur = new User(
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
	                     enchere.setUser(utilisateur);
	                     enchereList.add(enchere);
	                    
	                 }  
	                 
			     } catch (SQLException e) {
				 e.printStackTrace();
	             throw new DalException(e.getMessage());
			}
			return enchereList;
			
			

}
}

	
	
	

