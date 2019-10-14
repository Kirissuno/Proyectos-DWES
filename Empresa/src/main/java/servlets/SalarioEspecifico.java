package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.gestion.BBDD;

/**
 * Servlet implementation class SalarioEspecifico
 */
public class SalarioEspecifico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalarioEspecifico() {
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
			
			String respuesta = "";
			
			if(bbdd.salarioempleado(request.getParameter("dni")) > 0) { 
				respuesta = "El salario del empleado es de: "+bbdd.salarioempleado(request.getParameter("dni"))+" euros";
			}else{ 
				respuesta = "El empleado con ese DNI no existe";
			} 
			
			request.setAttribute("respuesta", respuesta);
			
			rd = request.getRequestDispatcher("/salarioespecifico.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
