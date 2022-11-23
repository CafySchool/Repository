package it.its.mywebapp.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.mywebapp.idao.DAOFactoryMethod;
import it.its.mywebapp.model.Event;
/**
 * Servlet implementation class EventServlet
 */
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
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
	Event event = new Event();
	public void execute(HttpServletRequest request, HttpServletResponse response) { 
		try {
			event.setEventName(request.getParameter("eventName"));
			event.setDescription(request.getParameter("description"));
			event.setStartDate(LocalDate.parse(request.getParameter("startDate")));
			boolean check = validate(event, request);
			RequestDispatcher rd;
			if (check) {
				DAOFactoryMethod.getInstance().getEventformDAO().save(event);
				ArrayList<Event> list =DAOFactoryMethod.getInstance().getEventformDAO().findAll();
				request.setAttribute("eventList", list);
				request.setAttribute("onlyTable", false);
				rd = request.getRequestDispatcher("resultEvent.jsp");
			} else {
				request.setAttribute("check", check);
				request.setAttribute("event", event);
				rd = request.getRequestDispatcher("indexEvent.jsp");
			}			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}
	public boolean validate(Event event, HttpServletRequest request) {
		boolean validate = true;
		if ("".equals(event.getEventName())) {
			validate = false;
			request.setAttribute("eventName", event.getEventName());
		}
		if ("".equals(event.getDescription())) {
			validate = false;
			request.setAttribute("description", event.getDescription());
		}
		return validate;
	}
}
