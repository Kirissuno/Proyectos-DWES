package controladores;

import java.sql.SQLException;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public interface DAO {
	
	List<Empleado> getAll();

	int salEspecifico(String dni);

	Empleado getEmp(String dni);

	void updateEmp(Empleado emp) throws SQLException;

	void updateSal(Empleado emp) throws SQLException, DatosNoCorrectosException;

}
