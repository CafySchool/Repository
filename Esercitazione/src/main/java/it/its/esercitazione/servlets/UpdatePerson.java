package it.its.esercitazione.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import it.its.esercitazione.domain.Person;
import it.its.esercitazione.idao.DAOFactoryMethod;
import it.its.esercitazione.utils.Util;


/**
 * Servlet implementation class PersonServlet
 */
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerson() {
        super();
        // TODO Auto-generated constructor stub
    }
	Person person = new Person();
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  JSONObject jObj = new JSONObject(Util.getBody(request));
		  
		  Iterator<String> it = jObj.keys();
		  Map<String,String> mappa = new HashMap<String, String>();
		  while(it.hasNext())
		  {
		    String key = it.next(); // get key
		    Object o = jObj.get(key); // get value
		    mappa.put(key, (String) o);
		  }
		  person.setId(mappa.get("id"));
		  String id = person.getId();
		  if(DAOFactoryMethod.getInstance().getPersonDAO().findById(id) != null) {
	    		DAOFactoryMethod.getInstance().getPersonDAO().delete(id);
	    	} else {
	    		System.out.println("errore");
	    	}
		  person.setName(mappa.get("name"));
		  person.setSurname(mappa.get("surname"));
		DAOFactoryMethod.getInstance().getPersonDAO().save(person);
	}	

}
