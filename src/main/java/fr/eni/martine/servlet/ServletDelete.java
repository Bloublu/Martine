package fr.eni.martine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.martine.bll.BllException;
import fr.eni.martine.bll.ProfilManager;
import fr.eni.martine.bo.User;


@WebServlet("/delete")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ProfilManager profilmanager;	
       
    
    public ServletDelete() {
        super();
       this.profilmanager = new ProfilManager();
    }
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String rue = request.getParameter("rue");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String nom = request.getParameter("nom");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String motdepasse = request.getParameter("motdepasse");
		
		
		HttpSession session = request.getSession();  
		
        User userConnecte = (User) request.getSession().getAttribute("user");
        int id = userConnecte.getId();
        
		userConnecte = this.profilmanager.DeleteUser(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, motdepasse, id);
		
		session.setAttribute("user", userConnecte);
		
		request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
			
		} catch (BllException e) {
			
			
			e.printStackTrace();
		}
		
		
		
	}

}
