package it.its.mywebapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.EmailValidator;

import it.its.mywebapp.idao.DAOFactoryMethod;
import it.its.mywebapp.model.Person;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	Person person = new Person();

	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		try {
			
			person.setName(request.getParameter("name"));
			person.setSurname(request.getParameter("surname"));
			person.setAge(Integer.parseInt(request.getParameter("age")));
			person.setSex(request.getParameter("sex"));
			person.setProvince(request.getParameter("province"));
			person.setEmail(request.getParameter("email"));
			// System.out.println(person);
			boolean check = validate(person, request);
			RequestDispatcher rd;
			if (check) {
				DAOFactoryMethod.getInstance().getWebformDAO().save(person);
				ArrayList<Person> list =DAOFactoryMethod.getInstance().getWebformDAO().findAll();
				request.setAttribute("personList", list);
				request.setAttribute("onlyTable", false);
				rd = request.getRequestDispatcher("result.jsp");
			} else {
				request.setAttribute("check", check);
				request.setAttribute("person", person);
				rd = request.getRequestDispatcher("indexPerson.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public boolean validate(Person person, HttpServletRequest request) {
		boolean validate = true;
		if ("".equals(person.getName())) {
			validate = false;
			request.setAttribute("name", person.getName());
		}
		if ("".equals(person.getSurname())) {
			validate = false;
			request.setAttribute("surname", person.getSurname());
		}
		if (person.getAge() < 18) {
			validate = false;
			request.setAttribute("age", person.getAge());
		}

		if (!"m".equals(person.getSex()) && !"f".equals(person.getSex())) {
			validate = false;
			request.setAttribute("sex", person.getSex());
		}
		if ("".equals(person.getEmail())) {
			validate = false;
			request.setAttribute("email", person.getEmail());

		} else {
			if (!EmailValidator.getInstance().isValid(person.getEmail())) {
				validate = false;
				request.setAttribute("email", person.getEmail());
			}

		}
		return validate;
	}
}
