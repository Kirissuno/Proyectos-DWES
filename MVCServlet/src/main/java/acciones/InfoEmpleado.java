package acciones;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.EmpleadoDAO;
import laboral.Empleado;

public class InfoEmpleado implements Facade {
	EmpleadoDAO dao;

	public InfoEmpleado() {
		super();
		dao = new EmpleadoDAO();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String vista = "/edicionempleado.jsp";
		String dni = request.getParameter("dni");
		
		Empleado empleado = dao.getEmp(dni);
		
		request.setAttribute("empleado", empleado);
	
		return vista;
	}
	

}
