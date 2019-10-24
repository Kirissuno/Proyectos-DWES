package acciones;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.EmpleadoDAO;

public class TodosLosEmpleados implements Facade {
	EmpleadoDAO dao;
	
	public TodosLosEmpleados() {
		super();
		dao = new EmpleadoDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String vista = "/empleados.jsp";
		request.setAttribute("lista", dao.getAll());
		return vista;
	}
}
