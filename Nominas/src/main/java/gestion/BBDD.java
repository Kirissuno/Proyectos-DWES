package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public class BBDD {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		public BBDD() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados","estudiante","estudiante");
		}
		
		public List<String> todoslosempleados() throws ClassNotFoundException, SQLException {
			stmt = con.createStatement();
			
			List<String> lista = new ArrayList<String>();

			rs = stmt.executeQuery("select * from Empleados");		
			while(rs.next()) {
				char sexo = rs.getString(3).trim().charAt(0);
				String empleado = rs.getString(1)+","+rs.getString(2)+","+sexo+","+rs.getInt(4)+","+rs.getInt(5);
				lista.add(empleado);
			}
						
			return lista;
	
		}
		
		public void cargarficherobackup() {
			
		}
		
		public int salarioempleado(String dni) throws SQLException {
			stmt = con.createStatement();
			String consulta = "select sueldo from Nominas where dni = '"+dni+"'";
			rs = stmt.executeQuery(consulta);
			
			int sueldo = 0;
			
			while(rs.next()) {
				sueldo = rs.getInt("Sueldo");
			}
			
			return sueldo;
			
		}
		
		private List<String> todoslossalariosydni() throws SQLException{
			List<String> lista = new ArrayList<String>();
			stmt = con.createStatement();
			String consulta = "select dni, sueldo from Nominas";
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				lista.add(rs.getString("dni")+","+rs.getInt("sueldo"));
			}
			
			con.close();
			return lista;
		}
		
		private Empleado emplexistente(String dni) throws SQLException, DatosNoCorrectosException {
			Empleado empleado = null;
			String consulta = "select * from Empleados where dni like '"+dni+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				empleado = new Empleado(rs.getString("nombre"), 
						rs.getString("dni"), 
						rs.getString("sexo").charAt(0),
						rs.getInt("categoria"),
						rs.getInt("anyos"));
			}
			
			return empleado;
			
		}
		
		public void altaempleado(Empleado emp) throws SQLException, DatosNoCorrectosException {
			stmt = con.createStatement();
			String consulta = "Insert into Empleados values ('"+emp.nombre+"','"+emp.dni+"','"+emp.sexo+"',"+emp.getCategoria()+","+emp.anyos+")";
			
			if(emplexistente(emp.dni) == null) {
				stmt.executeUpdate(consulta);
			}else {
				throw new DatosNoCorrectosException("Empleado con ese DNI ya existente");
			}
			
		}
		
		public void cerrarconexion() throws SQLException {
			con.close();
		}
		
	
}
