package it.its.esercitazione.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.esercitazione.idao.DAOFactoryMethod;



/**
 * Servlet implementation class DeletePerson
 */
public class DeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePerson() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doDelete(HttpServletRequest req, HttpServletResponse response) throws IOException {
    	String id = req.getParameter("id");
    	if(DAOFactoryMethod.getInstance().getPersonDAO().findById(id) != null) {
    		DAOFactoryMethod.getInstance().getPersonDAO().delete(id);
    	} else {
    		System.out.println("errore");
    	}
		response.setContentType("text/plain");
		response.getWriter().println("Person id deleted: " + id);
		
    	
    	
    }
    
}
