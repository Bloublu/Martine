package fr.eni.martine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.martine.bll.ArticleManager;
import fr.eni.martine.bo.Article;



@WebServlet("/DetailVente")
public class ServletDetailVente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Appel de la méthode getNoArticle via la BLL (manager)
		//Article article = ArticleManager.getNoArticle(NoArticle);
		
		
		request.getRequestDispatcher("/WEB-INF/detailVente.jsp").forward(request, response);
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
