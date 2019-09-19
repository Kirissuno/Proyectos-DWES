package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BBDD {
		
		Connection con;
		
		public BBDD() throws SQLException {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nominas","estudiante","estudiante");
		}
		
		public List<String> selectall() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt = con.createStatement();
			
			List<String> lista = new ArrayList<String>();

			ResultSet rs = stmt.executeQuery("select * from Empleados");		
			while(rs.next()) {
				char sexo = rs.getString(3).trim().charAt(0);
				String empleado = rs.getString(1)+","+rs.getString(2)+","+sexo+","+rs.getInt(4)+","+rs.getInt(5);
				lista.add(empleado);
			}
			con.close();
			
			
			return lista;
			
		
		}
		
	
}
