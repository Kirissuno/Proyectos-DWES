package acciones;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.EmpleadoDAO;
import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public class ModificarEmpleado implements Facade {
	EmpleadoDAO dao;
	
	public ModificarEmpleado() {
		super();
		dao = new EmpleadoDAO();
	}

	
	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String vista = "/modificacion.jsp";
		
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		char sexo = request.getParameter("sexo").trim().charAt(0);
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int anyos = Integer.parseInt(request.getParameter("anyos"));
		
		Empleado antesdeactualizar = dao.getEmp(dni);
					
		Empleado empl = null;
		
		try {
			empl = new Empleado(nombre, dni, sexo, categoria, anyos);
			dao.updateEmp(empl);
			dao.updateSal(empl);
		} catch (DatosNoCorrectosException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					
		Boolean resolucion = null;
		if( antesdeactualizar.nombre.equals(empl.nombre) && antesdeactualizar.sexo == empl.sexo && antesdeactualizar.getCategoria() == empl.getCategoria() && antesdeactualizar.anyos == empl.anyos ) {
			resolucion = false;
		}else {
			resolucion = true;
		}
		
		request.setAttribute("resolucion", resolucion);
		
		return vista;
	}

}
