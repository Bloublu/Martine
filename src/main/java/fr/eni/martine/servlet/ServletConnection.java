package fr.eni.martine.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.martine.bll.ConnectManager;
import fr.eni.martine.bll.ConnectionManager;
import fr.eni.martine.dal.DalException;
import fr.eni.martine.servlet.BLLExeception.BllException;


@WebServlet("/connection")
public class ServletConnection extends HttpServlet {
	
	private  ConnectionManager connectionmanager;
       
   
    public ServletConnection() {
        super();
        this.connectionmanager = new ConnectionManager();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/PageConnection.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1- on recupere l'identifiant et le mot de passe
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");
		
		//2-On apelle la couche BLL avec ces parametres 
		try {
			this.connectionmanager.ConnectUserBll(identifiant, motdepasse);
			
			String erreur = "Utilisateur ou mot de passe incorrect";
			 Boolean connect = connectionmanager.ConnectUserBll(identifiant, motdepasse);
				if(connect == true) {
					request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
				}
				else {
				request.setAttribute("erreur", "Utilisateur ou mot de passe incorrect");				
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/PageConnection.jsp"); 
					dispatcher.forward(request, response);

				}
				
		} catch (BllException e) {
			
			
			e.printStackTrace();
			
			
	
		}
		
	}

}
