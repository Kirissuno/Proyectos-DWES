package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Facade;
import acciones.InfoEmpleado;
import acciones.ModificarEmpleado;
import acciones.SalarioEspecifico;
import acciones.TodosLosEmpleados;


public class UnicoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	    
	public UnicoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		Facade ac;
		String nomVista;
		
		
		String accion = request.getParameter("accion");
		
		switch(accion) {
		case "consultarempleados":
			ac= new TodosLosEmpleados();
			nomVista = ac.ejecutar(getServletContext(), request, response);
			rd = request.getRequestDispatcher(nomVista);
			rd.forward(request, response);
			break;
			
		case "consultarsalario":
			ac= new SalarioEspecifico();
			nomVista = ac.ejecutar(getServletContext(), request, response);
			rd = request.getRequestDispatcher(nomVista);
			rd.forward(request, response);
			break;
			
		case "infoempleado":
			ac = new InfoEmpleado();
			nomVista = ac.ejecutar(getServletContext(), request, response);
			rd = request.getRequestDispatcher(nomVista);
			rd.forward(request, response);
			break;
			
		case "modificarenbd":
			ac = new ModificarEmpleado();
			nomVista = ac.ejecutar(getServletContext(), request, response);			
			rd = request.getRequestDispatcher(nomVista);
			rd.forward(request, response);
			break;
			
		default:
			break;
		}
		
	}

}
