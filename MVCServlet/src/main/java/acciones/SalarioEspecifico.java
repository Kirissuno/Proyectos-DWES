package acciones;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.EmpleadoDAO;

public class SalarioEspecifico implements Facade{
	EmpleadoDAO dao;
	
	public SalarioEspecifico() {
		super();
		dao = new EmpleadoDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String vista = "/salarioespecifico.jsp";
		String dni = request.getParameter("dni");
		int sal = dao.salEspecifico(dni);
		String respuesta = "";
		if (sal > 0) {
			respuesta ="El salario del empleado con DNI "+ dni +" es de "+ sal + " euros";
		}else {
			respuesta = "El empleado con ese DNI no existe";
		}
		request.setAttribute("respuesta", respuesta);
	
		return vista;
	}

}
