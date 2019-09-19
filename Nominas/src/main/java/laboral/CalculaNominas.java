package laboral;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import gestion.BBDD;

public class CalculaNominas {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		
//		try {
//			Empleado e1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
//			Empleado e2 = new Empleado("Ada Lovelace", "32000031R", 'F');
//			
//			System.out.println(escribe(e1, e2));
//			
//			e2.incrAnyo();
//			e1.setCategoria(9);
//			
//			System.out.println("---------------------");
//			
//			System.out.println(escribe(e1, e2));
//
//			
//		} catch (DatosNoCorrectosException e) {
//			System.out.println(e);
//		}
		
//		File empleados = new File("empleados.txt");
//		try {
//	        Scanner sc=new Scanner(empleados);
//	        while(sc.hasNextLine()){
//	            String empleado = sc.nextLine();
//	            
//	        }
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BBDD bbdd = new BBDD();
		for(String empleado : bbdd.selectall()) {
			System.out.println(empleado);
		}
		
		
	}
	
	private static String escribe (Empleado emp1, Empleado emp2) {
		return emp1.toString() + " y gana " + Nomina.sueldo(emp1) +"\n" + emp2.toString() + " y gana " + Nomina.sueldo(emp2);
	}

}
