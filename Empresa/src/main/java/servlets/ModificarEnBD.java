package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.gestion.BBDD;
import servlets.laboral.DatosNoCorrectosException;
import servlets.laboral.Empleado;

/**
 * Servlet implementation class ModificarEnBD
 */
public class ModificarEnBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarEnBD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		BBDD bbdd;
		try {
			bbdd = new BBDD();
			
			RequestDispatcher rd;
			
			String nombre = request.getParameter("nombre");
			String dni = request.getParameter("dni");
			
			Empleado antesdeactualizar = bbdd.sacaempleado(dni);
			
			char sexo = request.getParameter("sexo").trim().charAt(0);
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int anyos = Integer.parseInt(request.getParameter("anyos"));
						
			Empleado empl = new Empleado(nombre, dni, sexo, categoria, anyos);
			
			bbdd.reemplazaempleado(empl);
			bbdd.recalculasueldo(empl);
						
			Boolean resolucion = null;
			
			if( antesdeactualizar.nombre.equals(empl.nombre) && antesdeactualizar.sexo == empl.sexo && antesdeactualizar.getCategoria() == empl.getCategoria() && antesdeactualizar.anyos == empl.anyos ) {
				resolucion = false;
			}else {
				resolucion = true;
			}
			
			request.setAttribute("resolucion", resolucion);
			
			rd = request.getRequestDispatcher("/modificacion.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
