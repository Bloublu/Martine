package fr.eni.martine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//On recupere les champs de saisie de la creation du nouvel utilisateur
		
				String pseudo = request.getParameter("pseudo");
				String prenom = request.getParameter("prenom");
				String rue = request.getParameter("rue");
				String téléphone = request.getParameter("téléphone");
				String motdepasse = request.getParameter("motdepasse");
				String email = request.getParameter("email");
				String nom = request.getParameter("nom");
				String codepostal = request.getParameter("codepostal");
				String motdepasseconfirmation = request.getParameter("motdepasseconfirmation");
				String ville = request.getParameter("ville");
		
		request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

}
