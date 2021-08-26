package fr.eni.martine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.martine.bll.BllException;
import fr.eni.martine.bll.InscriptionManager;
import fr.eni.martine.bll.ProfilManager;
import fr.eni.martine.bo.User;
import fr.eni.martine.dal.DalException;


@WebServlet("/MonProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
private ProfilManager profilmanager;	
       
    
    public ServletMonProfil() {
        super();
       this.profilmanager = new ProfilManager();
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//On recupere les champs de saisie de la creation du nouvel utilisateur
			String pseudo = request.getParameter("pseudo");
			String prenom = request.getParameter("prenom");
			String rue = request.getParameter("rue");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			String nom = request.getParameter("nom");
			String codepostal = request.getParameter("codepostal");
			String ville = request.getParameter("ville");
			String motdepasse = request.getParameter("motdepasse");
			String nouveaumotdepasse = request.getParameter("nouveaumotdepasse");
			String motpasseconfirmation = request.getParameter("motpasseconfirmation");
			
			HttpSession session = request.getSession();       
	        User userConnecte = (User) request.getSession().getAttribute("user");
	        int id = userConnecte.getId();
	        
			//On apelle la couche BLL
			this.profilmanager.Mdp( motpasseconfirmation, nouveaumotdepasse);
			
			userConnecte = this.profilmanager.UpdateUser(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motdepasse, id);
			
			session.setAttribute("user", userConnecte);
			
			
			request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);				
				
			} catch (BllException e) {
				
				e.printStackTrace();
				request.setAttribute("messages", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);	
	}
		
		
		
	}
}
