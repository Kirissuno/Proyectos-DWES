package controladores;

import java.sql.SQLException;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public class EmpleadoDAO implements DAO{
	EmpleadoServicios servicio;
	
	public EmpleadoDAO()  {
		try {
			servicio = new EmpleadoServicios();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Empleado> getAll() {
		
		List<Empleado> lista = null;
		try {
			lista = servicio.todoslosempleadosEmpleado();
		} catch (ClassNotFoundException | SQLException | DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return lista;
	}
	
	@Override
	public int salEspecifico(String dni) {
		int sueldo = 0;
		
		try {
			sueldo = servicio.salarioempleado(dni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sueldo;
		
	}
	
	@Override
	public Empleado getEmp(String dni)  {
		Empleado empleado = null;
		
		try {
			empleado = servicio.sacaempleado(dni);
		} catch (SQLException | DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empleado;
		
	}
	
	@Override
	public void updateEmp(Empleado emp) throws SQLException {
		servicio.reemplazaempleado(emp);			
	}
	
	@Override
	public void updateSal(Empleado emp) throws SQLException, DatosNoCorrectosException {
		servicio.recalculasueldo(emp);
		
	}
	
}

