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
		
		  JSONObject jObj = new JSONObject(getBody(request));
		  
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
		
	public static String getBody(HttpServletRequest request)  {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        // throw ex;
	        return "";
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {

	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}	
		
		
		
		
//	
//	public Person execute(HttpServletRequest request, HttpServletResponse response) {
//		
//		try {
//			person.setName(request.getParameter("name"));
//			person.setSurname(request.getParameter("surname"));		
//			DAOFactoryMethod.getInstance().getPersonDAO().save(person);
//			RequestDispatcher rd;
//			rd = request.getRequestDispatcher("result.jsp");
//			rd.forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return person; 
//		
//	}

}
