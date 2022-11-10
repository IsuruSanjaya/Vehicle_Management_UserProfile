package vehicle.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vehicle.dao.*;
import vehicle.model.User;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDA userDAO;
	
	public void init() {
		userDAO = new UserDA();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String name=(String) request.getAttribute("name");

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response, name);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
//
	private void listUser(HttpServletRequest request, HttpServletResponse response, String savename)
			throws SQLException, IOException, ServletException {
		savename =(String) request.getSession().getAttribute("name");
		List<User> listUser = userDAO.selectAllUsers(savename);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String mobileNo = request.getParameter("mobileNo");
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		String vehicleNo = request.getParameter("vehicleNo");
		String vehicleType = request.getParameter("vehicleType");
		User newUser = new User(name,mobileNo,address,date,vehicleNo,vehicleType);
		userDAO.insertUser(newUser);
		request.getSession().setAttribute("name", name);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String mobileNo = request.getParameter("mobileNo");
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		String vehicleNo = request.getParameter("vehicleNo");
		String vehicleType = request.getParameter("vehicleType");


		User book = new User(id,name, mobileNo,address,date,vehicleNo,vehicleType);
		userDAO.updateUser(book);
		request.getSession().setAttribute("name",name);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp.jsp");

		response.sendRedirect("user-form.jsp");

	}

}
