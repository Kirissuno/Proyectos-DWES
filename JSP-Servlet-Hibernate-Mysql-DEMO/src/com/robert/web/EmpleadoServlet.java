package com.robert.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.robert.dao.EmpleadoDAO;
import com.robert.model.Empleado;

@WebServlet("/")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpleadoDAO empleadoDAO;
	
	public void init() {
		empleadoDAO = new EmpleadoDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmpleado(request, response);
				break;
			case "/delete":
				deleteEmpleado(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmpleado(request, response);
				break;
			default:
				listEmpleado(request, response);
				break;
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	private void listEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Empleado> listEmpleado = empleadoDAO.getAll();
		request.setAttribute("listEmpleado", listEmpleado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("empleado-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("empleado-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String dni = request.getParameter("dni");
		Empleado existingEmpleado = empleadoDAO.getSpec(dni);
		RequestDispatcher dispatcher = request.getRequestDispatcher("empleado-form.jsp");
		request.setAttribute("empleado", existingEmpleado);
		dispatcher.forward(request, response);

	}

	private void insertEmpleado(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String sexo = request.getParameter("sexo");
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));
		Integer anyos = Integer.parseInt(request.getParameter("anyos"));
		Empleado newEmpleado = new Empleado(nombre, dni, sexo, categoria, anyos);
		empleadoDAO.saveEmp(newEmpleado);
		response.sendRedirect("list");
	}

	private void updateEmpleado(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String sexo = request.getParameter("sexo");
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));
		Integer anyos = Integer.parseInt(request.getParameter("anyos"));

		Empleado user = new Empleado(nombre, dni, sexo, categoria, anyos);
		empleadoDAO.saveEmp(user);
		response.sendRedirect("list");
	}

	private void deleteEmpleado(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String dni = request.getParameter("dni");
		empleadoDAO.deleteEmp(dni);
		response.sendRedirect("list");
	}
}
