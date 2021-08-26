package fr.eni.martine.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.martine.bll.BllException;
import fr.eni.martine.bll.ListEnchereManager;
import fr.eni.martine.bll.EnchereUniqueManager;
import fr.eni.martine.bo.Enchere;
import fr.eni.martine.bo.User;

/**
 * Servlet implementation class Encheres
 */
@WebServlet("/Encheres")
public class ServletEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereUniqueManager managerEnchereUnique;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEncheres() {
        super();
        this.managerEnchereUnique = managerEnchereUnique;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noArticle = Integer.parseInt(request.getParameter("no_article"));
		
		Enchere enchereUnique = null;
		try {
			enchereUnique = EnchereUniqueManager.getEnchereUnique(noArticle);
		} catch (BllException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("enchere", enchereUnique);
		
		request.getRequestDispatcher("/WEB-INF/Encheres.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 int encherir = Integer.parseInt(request.getParameter("number"));
		 int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		
		EnchereUniqueManager eum = new EnchereUniqueManager();
		 try {
			eum.getEncherir(encherir, idArticle);
		} catch (BllException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 doGet(request, response);
	
	}

}
