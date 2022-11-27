package it.its.esercitazione.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.esercitazione.domain.Person;

public class Util {
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
	public static void render(Person person, HttpServletResponse response, String message) throws IOException {
		response.setContentType("text/plain");
		response.getWriter().println(message);
		response.getWriter().println("Person id: " + person.getId());
		response.getWriter().println("Name: " + person.getName());
		response.getWriter().println("Surname: " + person.getSurname());
	}
	public static void renderDelete(String id, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.getWriter().println("Person id deleted: " + id);
	}
}
