package it.its.esercitazione.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.its.esercitazione.domain.Person;
import it.its.esercitazione.idao.DAOFactoryMethod;


/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	Person person = new Person();
	
	public Person execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			person.setName(request.getParameter("name"));
			person.setSurname(request.getParameter("surname"));		
			DAOFactoryMethod.getInstance().getPersonDAO().save(person);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person; 
		
	}

}
