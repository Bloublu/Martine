package fr.eni.martine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.martine.bo.Article;
import fr.eni.martine.bo.Enchere;
import fr.eni.martine.bo.User;


public class ArticleDAOJdbcImpl implements ArticleDAO {

	// Requête pour insérer un article dans ARTICLES_VENDUS
	final String INSERT_INTO_ARTICLES_VENDUS ="INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, "
			+ "prix_initial, ) "
			+ "VALUES(?,?,?,?,?,?,?,?,?);";
	
	// Méthode select de la table ARTICLES VENDUS
	final String SELECT_ALL = "SELECT no_utilisateur, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_categorie, no_utilisateur, image FROM ARTICLES_VENDUS WHERE no_Article=?;";
	
	
	
	
	/**
     * @param id de l'article recherché
	 * @return 
	 * @return 
	 * @return 
     * @return un article
     */
	// Méthode ValiderArticle pour afficher champs de la vente 
	public Article ValiderArticle (int NoArticle) throws DalException {
		Article article = null;
		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
			PreparedStatement pSt = cnx.prepareStatement(SELECT_ALL);
			
			pSt.setInt(1, NoArticle); // Définit la valeur du 1er point d'interrogation
			ResultSet rs = pSt.executeQuery();
			
			while (rs.next()) { 
				
				int no_article = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDateTime debut_enchere = rs.getTimestamp("date_debut_enchere").toLocalDateTime();
				LocalDateTime fin_enchere = rs.getTimestamp("date_fin_enchere").toLocalDateTime();
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_categorie = rs.getInt("no_categorie");
				String etatVente = rs.getString("etat_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				String image = rs.getString("image");		
				
				article = new Article(no_article, nomArticle, description, debut_enchere, fin_enchere, prix_initial, prix_vente, no_categorie, etatVente, no_utilisateur, image);	 
			}
		} catch (SQLException e) {
			throw new DalException("erreur dans la méthode Valider Article");
		}
		return article;
	}
	
		
	
	
	
	// Méthode createArticle avec tous les paramètes :
	@Override
	public void CreateArticle (Article articleAVendre) throws DalException {
		try (Connection cnx = ConnectionProvider.getPoolConnexion()) {
	 	PreparedStatement pSt = cnx.prepareStatement(INSERT_INTO_ARTICLES_VENDUS, Statement.RETURN_GENERATED_KEYS);
	 			
	 	
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
        ResultSet clesGenerees = pSt.getGeneratedKeys(); // Récupérer les colonnes auto incrémentée
        if (clesGenerees.next()) {
            int idGenere = clesGenerees.getInt(1);
            articleAVendre.setNoArticle(idGenere);
        } 
 
	 	} catch (SQLException e) {
	 		
        e.printStackTrace();
        
        throw new DalException("erreur dans la méthode Create Article");

	 	}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
	

