package it.its.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.mywebapp.model.Registration;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	Registration registration = new Registration();

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			registration.setId(Integer.parseInt(request.getParameter("Id")));
			registration.setPersonId(Integer.parseInt(request.getParameter("PersonId")));
			registration.setEventId(Integer.parseInt(request.getParameter("EventId")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
