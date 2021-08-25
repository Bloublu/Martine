package fr.eni.martine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.martine.bll.BllException;
import fr.eni.martine.bll.ConnectionManager;
import fr.eni.martine.bll.ProfilAutreUtilisateurManager;
import fr.eni.martine.bo.User;



@WebServlet("/Profil")
public class ServletProfilAutreUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private  ProfilAutreUtilisateurManager profilautreutilisateur;
	
    
	   
    public ServletProfilAutreUtilisateur() {
        super();
        this.profilautreutilisateur = new ProfilAutreUtilisateurManager();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().getAttribute("User");
		
		
		int id = Integer.parseInt(request.getParameter("idutilisateur"));
		System.out.println(id);
		User connectUser=null;
		try {
			
			 connectUser = profilautreutilisateur.AffUtiliBll(id);
		} catch (BllException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("user",connectUser);
		
		request.getRequestDispatcher("/WEB-INF/ProfilAutreUtilisateur.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		}
		
	}


