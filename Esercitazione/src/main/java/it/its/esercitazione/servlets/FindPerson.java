package it.its.esercitazione.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.esercitazione.domain.Person;
import it.its.esercitazione.idao.DAOFactoryMethod;



/**
 * Servlet implementation class DeletePerson
 */
public class FindPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPerson() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
    		String id = request.getParameter("id");
    		Person person =DAOFactoryMethod.getInstance().getPersonDAO().findById(id);
    		response.setContentType("text/plain");
    		response.getWriter().println("Person id: " + person.getId());
    		response.getWriter().println("Name: " + person.getName());
    		response.getWriter().println("Surname: " + person.getSurname());
    }
}
