package it.its.mywebapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.mywebapp.idao.DAOFactoryMethod;
import it.its.mywebapp.model.Event;

/**
 * Servlet implementation class DeleteEventServlet
 */
public class DeleteEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEventServlet() {
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
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		DAOFactoryMethod.getInstance().getEventformDAO().delete(id);
		ArrayList<Event> eventList = DAOFactoryMethod.getInstance().getEventformDAO().findAll();
		req.setAttribute("eventList", eventList);
		req.setAttribute("onlyTable", true);
		req.getRequestDispatcher("resultEvent.jsp").forward(req, resp);
				
	}

}
