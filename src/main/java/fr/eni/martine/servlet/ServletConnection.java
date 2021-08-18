package fr.eni.martine.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.martine.bll.BllException;
import fr.eni.martine.bll.ConnectionManager;
import fr.eni.martine.bo.User;
import fr.eni.martine.dal.DalException;


@WebServlet("/connection")
public class ServletConnection extends HttpServlet {
	
	private  ConnectionManager connectionmanager;
	private User user;
       
   
    public ServletConnection() {
        super();
        this.connectionmanager = new ConnectionManager();
        this.user = new User();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().getAttribute(user.getPseudo());
		request.getRequestDispatcher("/WEB-INF/PageConnection.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1- on recupere l'identifiant et le mot de passe
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");
		
		//String petitNom = user.getPseudo();
		//2-On apelle la couche BLL avec ces parametres 
		try {
		
			 User connectUser = connectionmanager.ConnectUserBll(identifiant, motdepasse);
				if(connectUser  !=null) {
					
					request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
				}
				else {
				request.setAttribute("erreur", "Utilisateur ou mot de passe incorrect");				
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/PageConnection.jsp"); 
					dispatcher.forward(request, response);

				}
				
		} catch (BllException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/PageConnection.jsp"); 
			dispatcher.forward(request, response);
		}
		
	}

}
