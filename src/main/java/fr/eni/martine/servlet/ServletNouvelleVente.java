package fr.eni.martine.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.martine.bll.ArticleManager;
import fr.eni.martine.bo.Article;
import fr.eni.martine.bo.User;
import fr.eni.martine.dal.DalException;



@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    
	public ServletNouvelleVente() {
		super();
		
	}



	/**
	 * Méthode doGet redirige vers JSP
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// On redirige vers la JSP d'affichage 
		request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp").forward(request, response);

	}
		
		
		
	/**
	 * 
	 * Méthode doPost Traite les données envoyées par le formulaire
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime date_debut_enchere = LocalDateTime.parse(request.getParameter("date_debut_enchere") + " " + request.getParameter("time_debut_enchere"), formatter);
		LocalDateTime date_fin_enchere = LocalDateTime.parse(request.getParameter("date_fin_enchere") + " " + request.getParameter("time_fin_enchere"), formatter);
		int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
		int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
		// Récupérer no_utilisateur via le user :
		HttpSession session = request.getSession();
		User userConnecte = (User) session.getAttribute("user");
		// int no_utilisateur = userConnecte.getId();
		int no_utilisateur = 1;
		String image = request.getParameter("image");
		
		
		ArticleManager am = new ArticleManager();
		am.createArticle(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_initial, no_categorie, no_utilisateur, image);
		
		
		
				
		} catch (DalException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp").forward(request, response);
	

	}

	
}
