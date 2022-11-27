package it.its.esercitazione.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.esercitazione.domain.Person;
import it.its.esercitazione.idao.DAOFactoryMethod;
import it.its.esercitazione.utils.Util;



/**
 * Servlet implementation class DeletePerson
 */
public class FindAllPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllPerson() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
    		ArrayList<Person> list =DAOFactoryMethod.getInstance().getPersonDAO().findAll();
    		for(Person person : list) {
    			String personNumber = Integer.toString(list.indexOf(person)+1);
    			Util.render(person, response, "Person" + personNumber);
    		}
    }
    
}
