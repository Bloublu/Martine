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
import fr.eni.martine.bo.Enchere;


@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ListEnchereManager listManager;   

    
    public AccueilServlet() {
        super();
        this.listManager = new ListEnchereManager();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Enchere> enchereList= null;
		try {
			enchereList = ListEnchereManager.getEnchere();
		} catch (BllException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("enchereList", enchereList);
		
		request.getRequestDispatcher("/WEB-INF/PageAccueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request,response);
	}

}
