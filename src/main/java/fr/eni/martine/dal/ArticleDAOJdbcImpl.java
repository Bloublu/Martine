package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import fr.eni.martine.bo.Article;


public class ArticleDAOJdbcImpl implements ArticleDAO {

	
	final static String INSERT_INTO_ARTICLES_VENDUS ="INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, "
			+ "prix_initial, prix_vente, no_categorie, no_utilisateur, image) "
			+ "VALUES(?,?,?,?,?,?,?,?,?);";
	
	// Méthode createArticle avec tous les paramètes :
	
	@Override
	public void CreateArticle (Article articleAVendre) throws DalException {
		
		
	 	
		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	 	
		
	 	PreparedStatement pSt = cnx.prepareStatement(INSERT_INTO_ARTICLES_VENDUS);
	 	
	 	pSt.setString(1,articleAVendre.getNomArticle());
	 	pSt.setString(2,articleAVendre.getDescription());
	 	pSt.setTimestamp(3, java.sql.Timestamp.valueOf(articleAVendre.getDebutEnchere()));
	 	pSt.setTimestamp(4, java.sql.Timestamp.valueOf(articleAVendre.getFinEnchere()));
	 	pSt.setInt(5,articleAVendre.getPrixInitial());
	 	pSt.setInt(6,articleAVendre.getPrixVente());
	 	pSt.setInt(7,articleAVendre.getCategorie());
	 	pSt.setInt(8, articleAVendre.getNo_utilisateur());
	 	pSt.setString(9,articleAVendre.getImage());
	 	
	 	
         pSt.executeUpdate();
        
	 	} catch (SQLException e) {
	 		
        e.printStackTrace();
        
        throw new DalException("erreur dans la méthode Create Article");

	 	}
		
	}

	
	}
