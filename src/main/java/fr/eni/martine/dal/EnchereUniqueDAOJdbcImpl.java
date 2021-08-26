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

public class EnchereUniqueDAOJdbcImpl implements EnchereUniqueDAO {

	
	
	final static String SELECT_ENCHERE_UNIQUE = "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE encheres.no_article = ?;";
	private static final String UPDATE_ENCHERIR = "UPDATE ENCHERES SET montant_enchere = ? WHERE no_article = ?;";
	
	 @Override
    public Enchere selectUniqueEnchere(int noArticle) throws DalException {
        
        Enchere enchereUnique = new Enchere();
       
        Article article = null;
        User utilisateur = null;
        
        try 	(Connection cnx = ConnectionProvider.getPoolConnexion()) {
    	 		PreparedStatement pSt = cnx.prepareStatement(SELECT_ENCHERE_UNIQUE);
    	 		pSt.setInt(1, noArticle);
    	 		ResultSet rs = pSt.executeQuery();
            while (rs.next()) {
                   
					enchereUnique = new Enchere(
							 rs.getTimestamp("date_enchere").toLocalDateTime(),
           				rs.getInt("montant_enchere")
                           );
                   
                    article = new Article(
                   		 rs.getInt("no_article"),
                   		 rs.getString("nom_article"),
                   		 rs.getString("description"),
                   		 rs.getTimestamp("date_debut_enchere").toLocalDateTime(),
                   		 rs.getTimestamp("date_fin_enchere").toLocalDateTime(),                 		
                   		 rs.getInt("prix_initial"),
                   		 rs.getInt("prix_vente"),
                   		 rs.getInt("no_categorie"),
                   		 rs.getString("etat_vente"),
                   		 rs.getInt("no_utilisateur"),
                   		 rs.getString("image")	                    
                    );
                    enchereUnique.setArticle(article);
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
                    enchereUnique.setUser(utilisateur);
                
                   
                }  
                
		     } catch (SQLException e) {
			 e.printStackTrace();
            throw new DalException(e.getMessage());
		}
		return enchereUnique;
		
	 }
	
	public void Encherir(int encherir, int idArticle) throws DalException {
		
		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	 		PreparedStatement pSt = cnx.prepareStatement(UPDATE_ENCHERIR);
	 		pSt.setInt(1, encherir);
	 		pSt.setInt(2, idArticle);
	 		
	 		pSt.executeUpdate();
		}catch (SQLException e) {
			 e.printStackTrace();
	            throw new DalException(e.getMessage()); 
	}
	
}
}
