package laboral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import gestion.BBDD;
import gestion.Ficheros;

public class CalculaNominas {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, DatosNoCorrectosException, IOException {
		
		BBDD bbdd = new BBDD();;
		Ficheros ficheros = new Ficheros();
		
		boolean salir = false;		
		
		Scanner numeros = new Scanner(System.in);
		Scanner letras = new Scanner(System.in);
				
		while (!salir) {
		
			System.out.println("1. Ver todos los empleados \n"
					+ "2. Ver salario de un empleado especifico \n"
					+ "3. Submenu de edicion \n"
					+ "4. Recalcular y actualizar sueldo de un empleado \n"
					+ "5. Recalcular y actualizar sueldos de todos los empleados \n"
					+ "6. Realizar copia de seguridad de la BBDD en fichero \n"
					+ "7. Alta de nuevos empleados \n"
					+ "Introduce cualquier otra tecla para salir.");
			String menuprincipal = letras.nextLine();
		
			switch (menuprincipal) {
			case "1": 
				for(String empleado : bbdd.todoslosempleados()) {
					System.out.println(empleado);
				}
				break;
			
			case "2":
				System.out.println("Introduce el DNI del empleado del que quieres ver el sueldo");
				String dnisueldo = letras.nextLine();
				
				if(bbdd.salarioempleado(dnisueldo) > 0) {
					System.out.println("El salario del empleado con DNI: "+dnisueldo+" es de "+bbdd.salarioempleado(dnisueldo)+"€.");
				}else{
					System.out.println("El empleado con ese DNI no existe");
				}
				break;
			
			case "7":
				System.out.println("Alta manual o mediante fichero empleadosNuevos.txt? \n"
						+ "1. Manual \n"
						+ "2. Fichero \n");
				String opcionesalta = letras.nextLine();
				
				switch (opcionesalta) {
				case "1":
					System.out.println("Introduce el nombre del empleado");
					String altanombre = letras.nextLine();
					System.out.println("Introduce el DNI del empleado");
					String altadni = letras.nextLine().trim().toUpperCase();
					System.out.println("Introduce el Sexo del empelado F/M");
					String altasexo = letras.nextLine().trim().toUpperCase();
					if(altasexo.equals("F") || altasexo.equals("M")) {
						System.out.println("El empleado tiene categoria y anyos trabajados? \n"
								+ "1. Si \n"
								+ "2. No");
						String sinocategoria = letras.nextLine();
						if(sinocategoria.equals("1")) {
							System.out.println("Introduce la categoria del empleado");
							int altacategoria = numeros.nextInt();
							System.out.println("Introduce los anyos trabajados del empleado");
							int altaanyos = numeros.nextInt();
							bbdd.altaempleado(new Empleado(altanombre, altadni, altasexo.charAt(0), altacategoria, altaanyos));
							System.out.println("Consulta Enviada");
						}else {
							bbdd.altaempleado(new Empleado(altanombre, altadni, altasexo.charAt(0)));
							System.out.println("Consulta Enviada");
						}				
					}else {
						System.out.println("Sexo incorrecto");
					}
										
					break;
				
				case "2":
					ficheros.altaempleados();
					System.out.println("Consulta Enviada");
					break;

				default:
					System.out.println("Operación cancelada");
					break;
				}
				
				break;
				
			default:
				System.out.println("Hasta otra :)");
				ficheros.backupbbddafichero();
				bbdd.cerrarconexion();
				salir=true;
				break;
			}
		
		};
			
		letras.close();
		numeros.close();
	}
	
	/*private static String escribe (Empleado emp1, Empleado emp2) {
		return emp1.toString() + " y gana " + Nomina.sueldo(emp1) +"\n" + emp2.toString() + " y gana " + Nomina.sueldo(emp2);
	}*/

}
