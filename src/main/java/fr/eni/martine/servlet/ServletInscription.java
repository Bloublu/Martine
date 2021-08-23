package fr.eni.martine.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.martine.bll.BllException;
import fr.eni.martine.bll.InscriptionManager;

import fr.eni.martine.bo.User;





@WebServlet("/Inscription")
public class ServletInscription extends HttpServlet {

	private InscriptionManager inscriptionmanager;	
       
    
    public ServletInscription() {
        super();
       this.inscriptionmanager = new InscriptionManager();
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
		
		try {
				//On recupere les champs de saisie de la creation du nouvel utilisateur
				String pseudo = request.getParameter("pseudo");
				String prenom = request.getParameter("prenom");
				String rue = request.getParameter("rue");
				String telephone = request.getParameter("telephone");
				String motdepasse = request.getParameter("motdepasse");
				String email = request.getParameter("email");
				String nom = request.getParameter("nom");
				String codepostal = request.getParameter("codepostal");
				String ville = request.getParameter("ville");
				String motpasseconfirmation = request.getParameter("motpasseconfirmation");
				
								
				//On apelle la couche BLL
				this.inscriptionmanager.CreateUser(pseudo, motdepasse, prenom, rue, telephone, nom, codepostal, ville, email, motpasseconfirmation);
				request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);				
					
				} catch (BllException e) {
					
					e.printStackTrace();
					request.setAttribute("message", e.getMessage());
					request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
		}
	}
}
