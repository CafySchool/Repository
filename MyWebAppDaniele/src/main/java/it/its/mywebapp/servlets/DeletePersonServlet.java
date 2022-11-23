package it.its.mywebapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.its.mywebapp.idao.DAOFactoryMethod;
import it.its.mywebapp.model.Person;

public class DeletePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePersonServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(req, resp);
	}

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		DAOFactoryMethod.getInstance().getWebformDAO().delete(id);
		ArrayList<Person> personList = DAOFactoryMethod.getInstance().getWebformDAO().findAll();
		req.setAttribute("personList", personList);
		req.setAttribute("onlyTable", true);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
				
	}
}
