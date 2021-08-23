package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.martine.bo.Article;
import fr.eni.martine.bo.Enchere;
import fr.eni.martine.bo.User;

public class EnchereDAOJdbc implements EnchereDAO {

	
	final static String SELECT_ENCHERE = "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE etat_vente = 'EC';";
	
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
							 rs.getTimestamp("date_enchere").toLocalDateTime(),
            				rs.getInt("montant_enchere")
                            );
                    
                     article = new Article(
                    		 rs.getString("nom_article"),
                    		 rs.getString("description"),
                    		 rs.getTimestamp("date_debut_enchere").toLocalDateTime(),
                    		 rs.getTimestamp("date_fin_enchere").toLocalDateTime(),                 		
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
